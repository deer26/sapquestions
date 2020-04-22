package com.karaca.sapcertificate;

import android.provider.BaseColumns;

/**
 * Created by huseyin.karaca on 9.04.2018.
 */

public final class QuizContract {
    private  QuizContract(){}

    public static class QuestionsTable implements BaseColumns {
        public  static  final String TABLE_NAME ="mm_quiz";
        public  static  final String COLUMN_QUESTION ="question";
        public  static  final String COLUMN_OPTION1 ="option1";
        public  static  final String COLUMN_OPTION2 ="option2";
        public  static  final String COLUMN_OPTION3 ="option3";
        public  static  final String COLUMN_OPTION4 ="option4";
        public  static  final String COLUMN_OPTION5 ="option5";
        public  static  final String COLUMN_OPTION6 ="option6";
        public  static  final String COLUMN_ANSWER_NR1 ="answer_nr1";
        public  static  final String COLUMN_ANSWER_NR2 ="answer_nr2";
        public  static  final String COLUMN_ANSWER_NR3 ="answer_nr3";
        public  static  final String COLUMN_ANSWER_NR4 ="answer_nr4";
        public  static  final String COLUMN_ANSWER_NR5 ="answer_nr5";
        public  static  final String COLUMN_ANSWER_NR6 ="answer_nr6";
        public  static  final String COLUMN_DIFFICULTY ="difficulty";

    }
}
