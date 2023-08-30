package Main;

public class Participant {
    private int ID;
    private String name;
    private String teacher;
    private String category;
    private String medal;
    private String templateName;
    private String officialCategory;

    public Participant(int ID, String firstName, String lastName, String teacher, String category, String medal) {
        setID(ID);
        setName(firstName, lastName);
        setTeacher(teacher);
        setCategory(category);
        setMedal(medal);
        templateName = "";
        officialCategory = "";
    }

    public int getID() {
        return ID;
    }

    private void setID(int ID) {
        this.ID = ID;
    }


    @Override
    public String toString() {
        return ID + " | " + name + " | " + teacher + " | " + category + " | " + medal + " | " + officialCategory;
    }

    public String getTemplateName() {
        if (!templateName.equals("")) {
            return templateName;

        } else {
            switch (medal) {
                case "Platinum":
                    templateName = "Platinum";
                    break;
                case "Gold":
                    templateName = "Gold";
                    break;
                case "Silver":
                    templateName = "Silver";
                    break;
                case "Bronze":
                    templateName = "Bronze";
                    break;
                case "Well Done":
                    templateName = "WellDone";
                    break;
                case "Certificate":
                    if (teacher.equals("")){
                        templateName = "CertNoTeach";
                    }
                    else {
                        templateName = "CertWithTeach";
                    }
                    return templateName;
                case "":
                        templateName = "Clear";

                    return templateName;
            }
            switch (category) {

                case "8 years old and under":
                case "9 to 10 years old":
                case "11 to 12 years old":
                case "13 to 15 years old from music school":
                case "13 to 15 years old from NON music school":
                case "16 to 18 years old from music school":
                case "16 to 18 years old from NON music school":
                case "19 to 25 years old from music institution":
                case "19 years old or older from NON music institution":
                case "Duets: 13 years old and under":
                case "Duets: 14 to 18 years old":
                    templateName = templateName + "OwnChoice";
                    break;
                case "Diploma":
                case "GRADE 1":
                case "GRADE 2":
                case "GRADE 3":
                case "GRADE 4":
                case "GRADE 5":
                case "GRADE 6":
                case "GRADE 7":
                case "GRADE 8":
                case "Piano Concerto":
                    templateName = templateName + "Custom";
                    break;

            }
        }
        return templateName;
    }

    public String getOfficialCategory() {
        if (!officialCategory.equals("")) {
            return officialCategory;

        } else {
            switch (category.trim()) {

                case "8 years old and under":
                    officialCategory = "Own Choice Class\n8 y/o and under";
                    break;
                case "9 to 10 years old":
                    officialCategory = "Own Choice Class\n9-10 y/o";
                    break;
                case "11 to 12 years old":
                    officialCategory = "Own Choice Class\n11-12 y/o";
                    break;
                case "13 to 15 years old from music school":
                    officialCategory = "Own Choice Class\n(music school) 13-15 y/o";
                    break;
                case "13 to 15 years old from NON music school":
                    officialCategory = "Own Choice Class (NON \nmusic school) 13-15 y/o";
                    break;
                case "16 to 18 years old from music school":
                    officialCategory = "Own Choice Class\n(music school) 16-18 y/o";
                    break;
                case "16 to 18 years old from NON music school":
                    officialCategory = "Own Choice Class (NON \nmusic school) 16-18 y/o";
                    break;
                case "19 to 25 years old from music institution":
                    officialCategory = "Own Choice Class (music\ninstitution) 19-25 y/o";
                    break;
                case "19 years old or older from NON music institution":
                    officialCategory = "Own Choice Class\n(NON music institution)\n19 y/o or older";
                    break;
                case "Duets: 13 years old and under":
                    officialCategory = "Piano Duets\n13 y/o and under";
                    break;
                case "Duets: 14 to 18 years old":
                    officialCategory = "Piano Duets\n14-18 y/o";
                    break;
                case "Diploma":
                    officialCategory = "Diploma";
                    break;
                case "NON-Competative Category  Beginner or Initial grade":
                    officialCategory = "NON-Competitive\nCategory";
                    break;
                case "GRADE 1":
                case "GRADE 2":
                case "GRADE 3":
                case "GRADE 4":
                case "GRADE 5":
                case "GRADE 6":
                case "GRADE 7":
                case "GRADE 8":
                    officialCategory = "Grade " + category.charAt(category.length() - 1);
                    break;
                case "Piano Concerto":
                    officialCategory = "Piano Concerto";
                    break;
            }
        }
        return officialCategory;
    }

    public String getName() {
        return name;
    }

    private void setName(String firstName, String lastName) {
        this.name = firstName.trim() + " " + lastName.trim();
    }

    public String getTeacher() {
        return teacher;
    }

    private void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getCategory() {
        return category;
    }

    private void setCategory(String category) {
        this.category = category.trim();
    }

    public String getMedal() {
        return medal;
    }

    private void setMedal(String medal) {
        this.medal = medal.trim();
    }
}
