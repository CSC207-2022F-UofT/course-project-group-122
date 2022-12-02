public abstract class Answer{

    private int qustionID;
    private int userID;

    public Answer(int qustionID, int userID){
        this.userID = userID;
        this.qustionID = qustionID;
    }



    protected void setUserID(int ID){
        this.userID = ID;
    }

    public int getUserID(){
        return this.userID;
    }
}
