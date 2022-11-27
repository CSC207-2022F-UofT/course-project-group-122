public class scaleAnswer extends Answer{

    int degree;
    int upperBound;
    int lowerBound;

    public scaleAnswer(int degree, int upperBound, int lowerBound, int qID, int uID){
        super(qID, uID);
        this.degree = degree;
        this.upperBound = upperBound;
        this.lowerBound = lowerBound;
    }
    public void setAnswer(){

    }
    public int getAnswer(){
        return this.degree;
    }

    public void setAnswer(int ans){
        this.degree = ans;
    }
}
