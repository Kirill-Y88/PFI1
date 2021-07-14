package lesson1;

public class Person {
    protected String firstName;
    protected String lastName;
    protected String middleName;
    protected String country;
    protected String address;
    protected String phone;
    protected int age;
    protected String gender;


    private Person (BuilderPerson builderPerson){
        firstName = builderPerson.firstName;
        lastName = builderPerson.lastName;
        middleName = builderPerson.middleName;
        country = builderPerson.country;
        address = builderPerson.address;
        phone = builderPerson.phone;
        age = builderPerson.age;
        gender = builderPerson.gender;
    }


    public static class  BuilderPerson {
        private String firstName;
        private String lastName;
        private String middleName;
        private String country;
        private String address;
        private String phone;
        private int age;
        private String gender;



        public  BuilderPerson addFirstName(String firstName){
            this.firstName = firstName;
            return this;
        }

        public BuilderPerson addLastName(String lastNameName){
            this.lastName = lastName;
            return this;
        }

        public BuilderPerson addMiddleName(String middleName){
            this.middleName = middleName;
            return this;
        }

        public BuilderPerson addCountry(String country){
            this.country = country;
            return this;
        }

        public BuilderPerson addAddress(String address){
            this.address = address;
            return this;
        }

        public BuilderPerson addPhone(String phone){
            this.phone = phone;
            return this;
        }

        public BuilderPerson addAge(int age){
            this.age = age;
            return this;
        }

        public BuilderPerson addGender(String gender){
            this.gender = gender;
            return this;
        }

        public Person build(){
            return new Person(this);
        }

    }

}
