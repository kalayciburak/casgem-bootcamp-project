package com.torukobyte.bootcampproject.business.constants;

public class ValidationMessages {

    public static class User {
        public static final String FirstNameBlank = "First name cannot be blank";
        public static final String FirstNameValid = "First name must be between 3 and 50 characters";
        public static final String LastNameBlank = "Last name cannot be blank";
        public static final String LastNameValid = "Last name must be between 3 and 50 characters";
        public static final String DateOfBirthBlank = "Date of birth cannot be blank";
        public static final String NationalIdentityBlank = "National Identity cannot be blank";
        public static final String NationalIdentityValid = "National Identity must be 11 characther";
        public static final String EmailBlank = "Email cannot be blank";
        public static final String EmailValid = "Email must be valid";
        public static final String PasswordBlank = "Password cannot be blank";
        public static final String PasswordValid = "Password must be minimum 8 characters, at least one letter, one number and one special character:";
    }

    public static class Applicant{
        public static final String AboutBlank = "About cannot be blank";
        public static final String AboutValid = "About must be between 5 and 50 characters";
    }

    public static class Employee{
        public static final String PositionBlank = "Position cannot be blank";
        public static final String PositionValid = "Position must be between 2 and 50 characters";
    }

    public static class Instructor{
        public static final String CompanyBlank = "Company cannot be blank";
        public static final String CompanyValid = "Company must be between 2 and 50 characters";
    }

    public static class Bootcamp{
        public static final String NameBlank = "Name cannot be blank";
        public static final String NameValid = "Name must be between 2 and 50 characters";
        public static final String MinState = "State cannot be less than 1";
        public static final String MaxState = "State cannot be greater than 2";
        public static final String StartDateBlank = "Start date cannot be blank";
        public static final String EndDateBlank = "End date cannot be blank";
        public static final String InstructorIdBlank = "Instructor id cannot be blank";
    }

    public static class Blacklist{
        public static final String ReasonBlank = "Reason cannot be blank";
        public static final String ReasonValid = "Reason must be between 5 and 50 characters";
        public static final String ApplicantIdBlank = "Applicant id cannot be blank";
        public static final String DateBlank = "Date cannot be blank";
    }

    public static class Application{
        public static final String ApplicantIdBlank = "Applicant id cannot be blank";
        public static final String BootcampIdBlank = "Bootcamp id cannot be blank";
        public static final String MinState = "State cannot be less than 1";
        public static final String MaxState = "State cannot be greater than 4";
    }
}
