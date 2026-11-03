package hometask3.Builder;

public class BuilderClass {
    private String name;
    private String lastname;

    private int age;
    private String email;

    private BuilderClass(Builder builder) {
        this.name = builder.name;
        this.lastname = builder.lastname;
        this.age = builder.age;
        this.email = builder.email;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "{name = '" + name + "', lastname: '" + lastname + "', age: '" + age + "', email: '" + email + "'}";
    }

    public static class Builder {
        private String name;
        private String lastname;

        private int age = 0;
        private String email = "";

        public Builder(String input) {
            if (input != null && !input.isEmpty()) {
                String[] parts = input.split(" ");
                if (parts.length > 0) {this.name = parts[0];}
                if (parts.length > 1) {this.lastname = parts[1];}
            }
        }

        public Builder age(String age) {
            try {
                this.age = Integer.parseInt(age);
            } catch (NumberFormatException ignored) {}
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public BuilderClass build() {
            if (name == null || name.isEmpty() || lastname == null || lastname.isEmpty()) {
                return null;
            }
            return new BuilderClass(this);
        }
    }
}
