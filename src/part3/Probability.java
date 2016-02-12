package part3;

public class Probability
{
    private Double probability;

    public Probability(String probability)
    {
        try
        {
            Double number = Double.parseDouble(probability);
            if(number < 0 || number > 1)
            {
                throw new NumberFormatException();
            }
            this.probability = number;
        }
        catch (NumberFormatException e)
        {
            System.err.println("error: the input should be a float number equal to/greater than 0 and equal " +
                    "to/smaller than 1.");
            System.exit(1);
        }
    }

    public static void main(String args[])
    {
        if(args.length == 1)
        {
            Probability probability = new Probability(args[0]);
        }
        else
        {
            System.err.println("error: the input is invalid. it should be the the probability of picking a red ball.");
        }
    }
}