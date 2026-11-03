package hometask4;

public class LivelockDemo {
    private static volatile boolean running = true;
    static class Book {
        private Student student;
        public Book(Student student) {
            this.student = student;
        }
        public Student getStudent() {
            return student;
        }
        public synchronized void setStudent(Student student) {
            this.student = student;
        }
        public synchronized void open() {
            System.out.println("Book opened.");
        }
    }

    static class Student {
        private final String name;
        private boolean dontHaveABook = true;
        public Student(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
        public boolean isDontHaveABook() {
            return dontHaveABook;
        }

        public void openBook(Book book, Student otherStudent) {
            while (dontHaveABook && running) {
                if (book.getStudent() != this) {
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {}
                    continue;
                }
                if (otherStudent.isDontHaveABook()) {
                    System.out.println(name + " given book to " + otherStudent.getName());
                    book.setStudent(otherStudent);
                    continue;
                }
                book.open();
                dontHaveABook = false;
                System.out.println(name + " opened the book.");
                book.setStudent(otherStudent);
            }
        }
    }

    public static void run() {
        running = true;
        final Student alexey = new Student("Alexey");
        final Student gleb = new Student("Gleb");
        final Book book = new Book(alexey);

        new Thread(() -> {
            while (running) {
                alexey.openBook(book, gleb);
            }
        }).start();
        new Thread(() -> {
            while (running) {
                gleb.openBook(book, alexey);
            }
        }).start();
    }

    public static void stop() {
        running = false;
    }
}
