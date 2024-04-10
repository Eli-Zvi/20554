/**
 * Student Name: Ilay Zvi
 *  Date: 12/12/2023
 *  Class Name: Polynom
 */
import java.util.ArrayList;
import java.util.Arrays;

public class Polynom {

    ArrayList<Integer> powerArr = new ArrayList<>();
    ArrayList<Double> coefficientArr = new ArrayList<>();

    private Polynom() /* default constructor to create empty object, only used inside the class*/
    {}

    /**
     * Constructor for polynom
     * @param powerArr - a list of the powers of the elements of the polynomials, unsorted
     * @param coefficientArr - a list of the coefficient of the elements of the polynomials, unsorted
     * @throws Exception - arrays are of a different size
     */
    public Polynom(ArrayList<Integer> powerArr, ArrayList<Double> coefficientArr) throws Exception
    {
        if(powerArr.size() != coefficientArr.size())
            throw new Exception("Size of arrays is different");

        if(powerArr.size() == 0) // we treat a polynomial of size 0 as 0
        {}
        else { /* fill up and sort the list */

            /* add initial elements to the list so a comparison can be made */
            this.powerArr.add(powerArr.get(0));
            this.coefficientArr.add(coefficientArr.get(0));

            for (int i = 1; i < powerArr.size(); i++) {
                int j = 0;

                for (; j < this.powerArr.size(); j++) { /* adds the ith element to the list in its sorted position */
                    if (powerArr.get(i) > this.powerArr.get(j)) {
                        this.powerArr.add(j, powerArr.get(i));
                        this.coefficientArr.add(j, coefficientArr.get(i));
                        break;
                    }
                    else if(powerArr.get(i).equals(this.powerArr.get(j))) //check if user made a mistake and put the same power twice
                    {
                        this.coefficientArr.set(j,coefficientArr.get(i) + this.coefficientArr.get(j));
                        break;
                    }
                }

                if (j == this.powerArr.size()) { /* if we compared to the entire list and still didnt add the new element, add at the end of the list */
                    this.powerArr.add(powerArr.get(i));
                    this.coefficientArr.add(coefficientArr.get(i));
                }
            }
        }
    }

    public ArrayList<Double> getCoefficientArr() {
        return coefficientArr;
    }

    public ArrayList<Integer> getPowerArr() {
        return powerArr;
    }

    /**
     * adds this polynom with a given polynom poly
     * @param poly a given polynom object
     * @return returns the result of addition
     */
    public Polynom plus(Polynom poly)
    { /* there was a different way of doing this using the constructor which I figured out much later */

        Polynom result = new Polynom(); // create a result polynom object

        result.powerArr.addAll(this.powerArr); // add the powers of this polynom object into the powerArr of the result object
        result.coefficientArr.addAll(this.coefficientArr); // add the coefficients of this polynom object into the coefficientArr result object

        for(int i = 0 ; i < poly.powerArr.size(); i++)
        {
            int index = result.powerArr.indexOf(poly.powerArr.get(i)); /* checks if the power is already in the result list */
            double coefficientResult;

            if(index != -1) /* if the power is already in the list, we add it */
            {
                /* if the result of addition is not 0, we add the coefficient to the one in the list */
                if((coefficientResult = result.coefficientArr.get(index) + poly.coefficientArr.get(i)) != 0)
                    result.coefficientArr.set(index, coefficientResult);
                else /* if the reuslt is 0, we remove the power from the list and the coefficient */
                {
                    result.coefficientArr.remove(index);
                    result.powerArr.remove(index);
                }
            }
            else { /* if index == -1 then the power is not in the list meaning we have to insert the element into its sorted position in the list */
                int j = 0;

                for (; j < result.powerArr.size(); j++) {
                    if (poly.powerArr.get(i) > result.powerArr.get(j)) {
                        result.powerArr.add(j, poly.powerArr.get(i));
                        result.coefficientArr.add(j, poly.coefficientArr.get(i));
                        break;
                    }
                }

                if(j == result.powerArr.size()) {
                    result.powerArr.add(poly.powerArr.get(i));
                    result.coefficientArr.add(poly.coefficientArr.get(i));
                }
            }
        }

        return result;
    }

    /**
     * subtracts this polynom object from a given polynom object
     * @param poly a given polynom object
     * @return the result of subtraction
     */
    public Polynom minus(Polynom poly)
    {
        Polynom temp = new Polynom(); //create a temp polynom object

        temp.powerArr.addAll(poly.powerArr); //fill the polynom object up with the powers of poly object

        for(int i = 0; i < poly.powerArr.size();i++)
        {
            temp.coefficientArr.add(poly.coefficientArr.get(i) * -1); // negate the coefficient of poly object
        }

        return this.plus(temp); // add temp(same as doing poly1 + (-poly) = poly1 - poly)
    }

    /**
     *
     * @return
     */
    public Polynom derive()
    {
        Polynom result = new Polynom();

        for(int i = 0; i < this.powerArr.size(); i++)
        {
            if(this.powerArr.get(i) != 0) {
                result.coefficientArr.add(this.coefficientArr.get(i) * this.powerArr.get(i));
                result.powerArr.add(this.powerArr.get(i) - 1);
            }
        }

        return result;
    }

    /**
     * Returns the string representation of this Polynom object
     * @return the string representation of the object
     */
    public String toString()
    {
        if(this.powerArr.size() == 0) // we defined a list of size 0 to be the polynom 0
            return "0";

        String str = "";

        for (int i = 0; i < this.powerArr.size(); i++)
        {

            if(i != 0) { /* adds the appropriate operator */
                if (this.coefficientArr.get(i) > 0)
                    str += "+";
            }

            if(this.coefficientArr.get(i) != 1 || this.powerArr.get(i) == 0) //adds the coefficient to the string if the power is 0 and if the coefficient isnt 1
            {
                if(this.coefficientArr.get(i) == -1)
                    str += "-";
                else str += this.coefficientArr.get(i);
            }

            if(this.powerArr.get(i) > 1) //for n>1, write x^n
                str += "x^" + this.powerArr.get(i);
            else if(this.powerArr.get(i) == 1) { // for x^1 write "x"
                str += "x";
            }
        }

        return str;
    }


    /**
     * Returns if this Polynom instance is equal to a given Object
     * @param object - a given object to be compared to
     * @return result of comparison
     */
    public boolean equals(Object object) {

        if(object == null || !(object instanceof Polynom))
            return false;

        Polynom poly = (Polynom)object;

        /* compares the fields of the Polynom objects */
        return Arrays.equals(this.coefficientArr.toArray(),poly.coefficientArr.toArray()) && Arrays.equals(this.powerArr.toArray(),poly.powerArr.toArray());
    }
}
