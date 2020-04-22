package com.karaca.sapcertificate;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by huseyin.karaca on 9.04.2018.
 */

public class Question implements Parcelable{
    public  static final  String C_TFIN22_67 = "CO: C_TFIN22_67";
    public  static final  String C_TFIN22_66 = "CO: C_TFIN22_66";
    public  static final  String C_TFIN22_64 = "CO: C_TFIN22_64";
    public  static final  String C_TFIN52_66 = "FI: C_TFIN52_66";
    public  static final  String C_TSCM62_64 = "SD: C_TSCM62_64";
    public  static final  String C_TSCM62_65 = "SD: C_TSCM62_65";
    public  static final  String C_TSCM42_65 = "PP: C_TSCM42_65";
    public  static final  String C_TSCM42_66 = "PP: C_TSCM42_66";
    public  static final  String DIFFICULTY_KARMA = "Karaca";

    private  String question;
    private  String option1;
    private  String option2;
    private  String option3;
    private  String option4;
    private  String option5;
    private  String option6;
    private  String answerNr1;
    private  String answerNr2;
    private  String answerNr3;
    private  String answerNr4;
    private  String answerNr5;
    private  String answerNr6;
    private  String difficulty;

    public Question(){}

    public Question(String question, String option1, String option2, String option3,
                    String option4,String option5,String option6,
                    String answerNr1,String answerNr2,String answerNr3,
                    String answerNr4,String answerNr5,String answerNr6,String difficulty) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.option5 = option5;
        this.option6 = option6;
        this.answerNr1 = answerNr1;
        this.answerNr2 = answerNr2;
        this.answerNr3 = answerNr3;
        this.answerNr4 = answerNr4;
        this.answerNr5 = answerNr5;
        this.answerNr6 = answerNr6;
        this.difficulty = difficulty;
    }

    protected Question(Parcel in) {
        question = in.readString();
        option1 = in.readString();
        option2 = in.readString();
        option3 = in.readString();
        option4 = in.readString();
        option5 = in.readString();
        option6 = in.readString();
        answerNr1 = in.readString();
        answerNr2 = in.readString();
        answerNr3 = in.readString();
        answerNr4 = in.readString();
        answerNr5 = in.readString();
        answerNr6 = in.readString();
        difficulty = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(question);
        dest.writeString(option1);
        dest.writeString(option2);
        dest.writeString(option3);
        dest.writeString(option4);
        dest.writeString(option5);
        dest.writeString(option6);
        dest.writeString(answerNr1);
        dest.writeString(answerNr2);
        dest.writeString(answerNr3);
        dest.writeString(answerNr4);
        dest.writeString(answerNr5);
        dest.writeString(answerNr6);
        dest.writeString(difficulty);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator <Question> CREATOR = new Creator <Question>() {
        @Override
        public Question createFromParcel(Parcel in) {
            return new Question(in);
        }

        @Override
        public Question[] newArray(int size) {
            return new Question[size];
        }
    };

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getOption5() {
        return option5;
    }

    public void setOption5(String option5) {
        this.option5 = option5;
    }

    public String getOption6() {
        return option6;
    }

    public void setOption6(String option6) {
        this.option6 = option6;
    }

    public String getAnswerNr1() {
        return answerNr1;
    }

    public void setAnswerNr1(String answerNr1) {
        this.answerNr1 = answerNr1;
    }

    public String getAnswerNr2() {
        return answerNr2;
    }

    public void setAnswerNr2(String answerNr2) {
        this.answerNr2 = answerNr2;
    }

    public String getAnswerNr3() {
        return answerNr3;
    }

    public void setAnswerNr3(String answerNr3) {
        this.answerNr3 = answerNr3;
    }
    public String getAnswerNr4() {
        return answerNr4;
    }

    public void setAnswerNr4(String answerNr4) {
        this.answerNr4 = answerNr4;
    }

    public String getAnswerNr5() {
        return answerNr5;
    }

    public void setAnswerNr5(String answerNr5) {
        this.answerNr5 = answerNr5;
    }

    public String getAnswerNr6() {
        return answerNr6;
    }

    public void setAnswerNr6(String answerNr6) {
        this.answerNr6 = answerNr6;
    }



    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public static  String[] getAllDifficultyLevels(){

        return new String[]{
                C_TFIN22_67,
                C_TFIN22_66,
                C_TFIN22_64,
                C_TFIN52_66,
                C_TSCM62_64,
                C_TSCM62_65,
                C_TSCM42_65,
                C_TSCM42_66

        };
    }
}
