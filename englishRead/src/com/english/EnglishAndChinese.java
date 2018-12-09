package com.english;

class EnglishAndChinese{
    public String getEnglish() {
        return english;
    }
    public void setEnglish(String english) {
        this.english = english;
    }
    public String getChinese() {
        return chinese;
    }
    public void setChinese(String chinese) {
        this.chinese = chinese;
    }
    private String english;
    private String chinese;
    
    @Override
    public String toString() {
        return "["+ "english: "+ english + " | " + "chinese: "+ chinese + "]";
    }
    
}