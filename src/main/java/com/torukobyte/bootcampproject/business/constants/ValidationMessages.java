package com.torukobyte.bootcampproject.business.constants;

public class ValidationMessages {

    public static class User {
        public static final String FirstNameBlank = "First name is required";
        public static final String FirstNameValid = "First name must be between 2 and 50 characters";
        public static final String LastNameBlank = "Last name is required";
        public static final String LastNameValid = "Last name must be between 2 and 50 characters";
        public static final String DateOfBirthBlank = "Date of birth is required";
        public static final String NationalIdentityBlank = "National Identity is required";
        public static final String NationalIdentityValid = "National Identity must be 11 characther";
        public static final String EmailBlank = "Email is required";
        public static final String EmailValid = "Email must be valid";
        public static final String PasswordBlank = "Password is required";
        public static final String PasswordValid = "Password must be minimum 8 characters, at least one letter, one number and one special character:";
        public static final String ConfirmPasswordBlank = "Confirm password is required";
        public static final String ConfirmPasswordValid = "Confirm password must be same with password";
        public static final String OldPasswordBlank = "Old password is required";
        public static final String OldPasswordNotMatch = "Old password is not match";
        public static final String ThereIsNoChangeInPassword = "There is no change in the password. Please enter a new password";
    }

    public static class Applicant {
        public static final String AboutBlank = "About is required";
        public static final String AboutValid = "About must be between 5 and 50 characters";
    }

    public static class Employee {
        public static final String PositionBlank = "Position is required";
        public static final String PositionValid = "Position must be between 2 and 50 characters";
    }

    public static class Instructor {
        public static final String CompanyBlank = "Company is required";
        public static final String CompanyValid = "Company must be between 2 and 50 characters";
    }

    public static class Bootcamp {
        public static final String NameBlank = "Name is required";
        public static final String NameValid = "Name must be between 2 and 50 characters";
        public static final String MinState = "State cannot be less than 1";
        public static final String MaxState = "State cannot be greater than 2";
        public static final String StartDateBlank = "Start date is required";
        public static final String EndDateBlank = "End date is required";
        public static final String InstructorIdBlank = "Instructor id is required";
    }

    public static class Blacklist {
        public static final String ReasonBlank = "Reason is required";
        public static final String ReasonValid = "Reason must be between 5 and 50 characters";
        public static final String ApplicantIdBlank = "Applicant id is required";
        public static final String DateBlank = "Date is required";
    }

    public static class Application {
        public static final String ApplicantIdBlank = "Applicant id is required";
        public static final String BootcampIdBlank = "Bootcamp id is required";
        public static final String MinState = "State cannot be less than 1";
        public static final String MaxState = "State cannot be greater than 4";
    }
}
