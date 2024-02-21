import core.data.*;
import java.util.ArrayList;
import java.util.Scanner;

public class EpicMain 
{
    public static void main(String[] args)
    {

        //connect and load the datatsourcee
        DataSource ds = DataSource.connect("http://api.kivaws.org/v1/loans/newest.json");
        ds.setParam("page", "1");
        ds.setParam("per_page", "500");
        ds.load();
        ds.printUsageString();

        //put it in an arraylist
        ArrayList<Loaned> pg1 = ds.fetchList("Loaned",  "loans/name", "loans/use",
                "loans/loan_amount", "loans/location/country", "loans/activity");

        //what are the most common reasons for people to take out loans?

        //make a counter for each reason
        ArrayList<String> categories = new ArrayList<>();
        ArrayList<Integer> nums = new ArrayList<>();


        //agriculture, animal sales, livestock, dairy, cattle, pigs, and poultry, include buying animals and food
        //agriculture, farming, farm supplies, cheese making, fishing, fish selling

        int agriculture = 0;
        categories.add("Agriculture");
        
        //transportation, taxi, vehicle, repairs, rickshaw
        int transport = 0;
        categories.add("Transport");

        //primary/secondary school costs, higher education costs
        int edu = 0;
        categories.add("Education");

        //food, food production/sales, food stall, fruits & vegetables, food market, retail, grocery store, general store
        //milk sales, cereals, consumer goods, clothing sales, clothing, used clothing, beverages, goods distribution, textiles
        int retail = 0;
        categories.add("Retail");

        //pharmacy, dental, medical clinic
        int medical = 0;
        categories.add("Medical");

        //personal housing expenses, personal expenses, home energy, home appliances, services
        int personal = 0;
        categories.add("Personal Expenses");

        //furniture making, metal shop, home products sale, cosmetics sale, bakery, butcher shop, spare parts, charcoal sales, timber sales
        //fuel/firewood
        int otherSales = 0;
        categories.add("Other Sales");

        //construction supplies, property
        int construction = 0;
        categories.add("Construction");

        //sewing, beauty salon, tailoring, printing, internet cafe, weaving, barber shop, 
        int otherServices = 0;
        categories.add("Other Services");




        for (Loaned l:pg1)
        {
            if (l.getActivity().equals("Livestock") || l.getActivity().equals("Pigs") || l.getActivity().equals("Cattle")
            || l.getActivity().equals("Poultry") || l.getActivity().equals("Dairy") || l.getActivity().equals("Animal Sales")
            || l.getActivity().equals("Agriculture") || l.getActivity().equals("Farming") || l.getActivity().equals("Farm Supplies") 
            || l.getActivity().equals("Agriculture") || l.getActivity().equals("Cheese Making")||l.getActivity().equals("Fish Selling") 
            || l.getActivity().equals("Fishing"))
            {
                agriculture++;
            }

            if (l.getActivity().equals("Transportation") || l.getActivity().equals("Taxi") || l.getActivity().equals("Vehicle Repairs")
            || l.getActivity().equals("Motorcycle Transport") || l.getActivity().equals("Vehicle") || l.getActivity().equals("Rickshaw"))
            {
                transport++;
            }

            if (l.getActivity().equals("Primary/secondary school costs") || l.getActivity().equals("Higher education costs"))
            {
                edu++;
            }

            if (l.getActivity().equals("Food") || l.getActivity().equals("Food Production/Sales") || l.getActivity().equals("Fruits & Vegetables")
            || l.getActivity().equals("Food Stall") || l.getActivity().equals("Food Market") || l.getActivity().equals("Retail") ||
            l.getActivity().equals("Grocery Store") || l.getActivity().equals("General Store") || l.getActivity().equals("Milk Sales")
            || l.getActivity().equals("Cereals") || l.getActivity().equals("Consumer Goods") || l.getActivity().equals("Clothing Sales")
            || l.getActivity().equals("Clothing") || l.getActivity().equals("Used Clothing") || l.getActivity().equals("Beverages")
            || l.getActivity().equals("Goods Distribution") || l.getActivity().equals("Textiles"))
            {
                retail++;
            }

            if (l.getActivity().equals("Medical Clinic") || l.getActivity().equals("Pharmacy") || l.getActivity().equals("Dental"))
            {
                medical++;
            }

            if (l.getActivity().equals("Personal Expenses") || l.getActivity().equals("Personal Housing Expenses") || l.getActivity().equals("Home Energy")
            || l.getActivity().equals("Home Energy") || l.getActivity().equals("Home Appliances") || l.getActivity().equals("Services"))
            {
                personal++;
            }

            if (l.getActivity().equals("Furniture Making") || l.getActivity().equals("Metal Shop") || l.getActivity().equals("Home Products Sale")
            || l.getActivity().equals("Cosmetics Sale") || l.getActivity().equals("Bakery") || l.getActivity().equals("Butcher Shop")
            || l.getActivity().equals("Spare Parts") || l.getActivity().equals("Timber Sales") || l.getActivity().equals("Charcoal Sales"))
            {
                otherSales++;
            }

            if (l.getActivity().equals("Construction Supplies") || l.getActivity().equals("Property"))
            {
                construction++;
            }

            if (l.getActivity().equals("Sewing") || l.getActivity().equals("Beauty Salon") || l.getActivity().equals("Tailoring")
            || l.getActivity().equals("Printing") || l.getActivity().equals("Internet Cafe") || l.getActivity().equals("Weaving")
            || l.getActivity().equals("Barber Shop"))
            {
                otherServices++;
            }



        }

        //print out the result
        System.out.println("Loans taken out: ");
        System.out.println("for agriculture related things like livestock,fish, their feed, and seeds: " + agriculture);
        System.out.println("for vehicle maintenance, parts, buying and selling: " + transport);
        System.out.println("for primary, secondary, and higher education school fees: " + edu);
        System.out.println("to sell/restock retail necessities like food, clothing, and others: " + retail);
        System.out.println("to buy medicine, dental care, or medical services: " + medical);
        System.out.println("for personal expenses like housing, house renovation, etc;: " + personal);
        System.out.println("for other kinds of stores like home producs, cosmetics, and bakeries: " + otherSales);
        System.out.println("for construction materials: " + construction);
        System.out.println("for services like tailoring, printing, and beauty salons: " + otherServices);

        //ads the numbers to an array
        nums.add(agriculture);
        nums.add(transport);
        nums.add(edu);
        nums.add(retail);
        nums.add(medical);
        nums.add(personal);
        nums.add(otherSales);
        nums.add(construction);
        nums.add(otherServices);

        //finds the category with the most loans
        int max = 0;
        int index = 0;
        for (int i = 0; i < nums.size(); i++)
        {
            if (nums.get(i) > max)
            {
                max = nums.get(i);
                index = i;
            }
        }
        System.out.println("The category with the most loans is " + categories.get(index) + " with " + nums.get(index) + " loans.");

        //finds the categorie with the second most loans
        int max2 = 0;
        int index2 = 0;
        for (int i = 0; i < nums.size(); i++)
        {
            if (nums.get(i) < max && nums.get(i) > max2)
            {
                max2 = nums.get(i);
                index2 = i;
            }
        }
        System.out.println("The category with the second most loans is " + categories.get(index2) + " with " + nums.get(index2) + " loans.");

        //finds the third most loans
        int max3 = 0;
        int index3 = 0;
        for (int i = 0; i < nums.size(); i++)
        {
            if (nums.get(i) < max2 && nums.get(i) > max3)
            {
                max3 = nums.get(i);
                index3 = i;
            }
        }
        System.out.println("The category with the third most loans is " + categories.get(index3) + " with " + nums.get(index3) + " loans.");




    }

}
