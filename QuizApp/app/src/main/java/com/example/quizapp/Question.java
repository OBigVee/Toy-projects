package com.example.quizapp;

public class Question {
    private int textResourceId;
    private boolean answerTrue;

//
//    public Question(int textResourceId, boolean answerTrue){
//        mAnswerTrue = answerTrue;
//        mTextResourceId = textResourceId;
//    }

    public Question(int TextResourceId, boolean answerTrue){
        this.textResourceId = TextResourceId;
        this.answerTrue = answerTrue;
    }

    public int getTextResourceId() {
        return textResourceId;
    }

    public void setTextResourceId(int textResourceId) {
        this.textResourceId = textResourceId;
    }

    public boolean isAnswerTrue() {
        return answerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        this.answerTrue = answerTrue;
    }
}
