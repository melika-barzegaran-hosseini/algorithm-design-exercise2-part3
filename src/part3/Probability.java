package part3;

import java.util.Random;

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

    private boolean pick()
    {
        return new Random().nextDouble() < probability;
    }

    private void compute()
    {
        Integer[] numbers = {30, 300, 3000, 30000};

        for(Integer number : numbers)
        {
            int sum = 0;
            for(int counter = 0; counter < number; counter++)
            {
                sum += (pick() ? 1 : 0);
            }
            System.out.format("number of picking red balls = %-5d   number of pickings = %-5d   probability = %f\n",
                    sum, number, (new Double(sum)/number));
        }
    }

    public static void main(String args[])
    {
        if(args.length == 1)
        {
            Probability probability = new Probability(args[0]);
            probability.compute();
        }
        else
        {
            System.err.println("error: the input is invalid. it should be the the probability of picking a red ball.");
        }
    }
}