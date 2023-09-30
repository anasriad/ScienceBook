package com.example.sciencebook;

public class CtageoryUtility {
    static String rank;
    static String getRank(float Score){
        if (Score>= 0.00 && Score<60.00){
            rank="Very Poor, (3ti 9raya Tissa3)";
        } else if (Score>=60.00 && Score<70.00) {
            rank="Poor, (walo am3llem)";
        } else if (Score>=70.00 && Score <80.00) {
            rank="Kayn Amal, (hadik hadiiik)";
        } else if (Score>=80.00 && Score<90.00){
            rank ="Saaa7a, Very Good am3llem";
        } else {
            rank = "Ma3ndi Mangoul, Excellent albatal Keep Going <3";
        }
        return rank;
    }
    static String getHexValue(){
        switch (rank) {
            case "Very Poor, (3ti 9raya Tissa3)":
                return "#650101";
            case "Poor, (walo am3llem)":
                return "#A10505";
            case "Kayn Amal, (hadik hadiiik)":
                return "#29A59A";
            case "Saaa7a, Very Good am3llem":
                return "#0BA664";
            default:
                return "#19D313";
        }
    }
}
