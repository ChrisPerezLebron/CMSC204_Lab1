import java.util.ArrayList;

public class GradeBook
{
   private double[] scores;
   private int scoresSize;

   /**
      Constructs a gradebook with no scores and a given capacity.
      @capacity the maximum number of scores in this gradebook
   */
   public GradeBook(int capacity)
   {
      scores = new double[capacity];
      scoresSize = 0;
   }

   /**
      Adds a score to this gradebook.
      @param score the score to add
      @return true if the score was added, false if the gradebook is full
   */
   public boolean addScore(double score)
   {
      if (scoresSize < scores.length)
      {
         scores[scoresSize] = score;
         scoresSize++;
         return true;
      }
      else
         return false;      
   }

   /**
      Computes the sum of the scores in this gradebook.
      @return the sum of the scores
   */
   public double sum()
   {
      double total = 0;
      for (int i = 0; i < scoresSize; i++)
      {
         total = total + scores[i];
      }
      return total;
   }
      
   /**
      Gets the minimum score in this gradebook.
      @return the minimum score, or 0 if there are no scores.
   */
   public double minimum()
   {
	// STUDENT TODO: Implement your logic here
	  
    
      
      //set smallest to the first item in the array
      double smallest = scores[0];
      
      /* 
       * iterate through all other array items to see if they 
       * are smaller than current minimum
       * 
       * I do understand that this version of the for loop will cause
       * the first element to be tested again. However, it produces much
       * more readable code. Hence, I am intentionally allowing an extra 
       * iteration as sacrifice for better readability. 
      */
	  for(double score: scores) 
		  if (score  < smallest && score != 0)
			  smallest = score;
	  
      return smallest;
   }

   /**
      Gets the final score for this gradebook.
      @return the sum of the scores, with the lowest score dropped if 
      there are at least two scores, or 0 if there are no scores.
   */
   public double finalScore() 
   {
      if (scoresSize == 0)
         return 0;
      else if (scoresSize == 1)
         return scores[0];
      else
         return sum() - minimum();
   }
   
   /**
    * returns the scoresSize field
    * @return the value stored in the scoresSize field
    */
   public int getScoreSize() {
	   return scoresSize;
   }
   
   /**
    * converts the scores Array into a string
    * @return a string representing all the grades in the array
    */
   public String toString() {
	   String str = "";
	   for (double score : scores)
		   if (score != 0)
			   str += score + " ";
	   
	   return str;
   }
}
