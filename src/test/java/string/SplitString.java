package string;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SplitString {

	public static void main(String[] args) throws ParseException {
		String givenSlot = "Oct 29 - Nov 4";
        String[] date = givenSlot.split(" - ");
        for(int i=0; i<date.length;i++) {
        	String parsed = date[i]; 
        	System.out.println(parsed);
        	
        }

        int year = Calendar.getInstance().get(Calendar.YEAR);
        String y = Integer.toString(year);

        String startingDate = date[0]+" "+y; 
        String regex1 = "([a-zA-Z]+) ([0-9]+) ([0-9]+)";
        String regex2 = "([a-zA-Z]+) ([0-9]) ([0-9]+)";

        Pattern startPattern = Pattern.compile(regex1);
        Matcher startMatcher = startPattern.matcher(startingDate);

        Pattern startPattern2 = Pattern.compile(regex2);
        Matcher startMatcher2 = startPattern2.matcher(startingDate);

        if(startMatcher.find()==true) {
            String OLD_FORMAT = "MMM dd yyyy";
            String NEW_FORMAT = "MM/dd/yyyy";
            System.out.println(startingDate);
            String newDateString;
            SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
            Date d = sdf.parse(startingDate);//parse the old date
            sdf.applyPattern(NEW_FORMAT);
            newDateString = sdf.format(d);//convert to new format
            System.out.println(newDateString);
        }else if(startMatcher2.find()==true){
            String OLD_FORMAT = "MMM d yyyy";
            String NEW_FORMAT = "MM/dd/yyyy";
            String newDateString;
            SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
            Date d = sdf.parse(startingDate);//parse the old date
            sdf.applyPattern(NEW_FORMAT);
            newDateString = sdf.format(d);//convert to new format
            System.out.println(newDateString);
        } else{
            System.out.println("invalid format");
        }

        String endDate = date[1]+" "+y;

        Pattern endPattern = Pattern.compile(regex1);
        Matcher endMatcher = endPattern.matcher(startingDate);

        Pattern endPattern2 = Pattern.compile(regex2);
        Matcher endMatcher2 = endPattern2.matcher(startingDate);

        if(endMatcher.find()==true) {
            String OLD_FORMAT = "MMM dd yyyy";
            String NEW_FORMAT = "MM/dd/yyyy";
            System.out.println(endDate);
            String newDateString;
            SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
            Date d = sdf.parse(endDate);
            sdf.applyPattern(NEW_FORMAT);
            newDateString = sdf.format(d);
            System.out.println(newDateString);
        }else if(endMatcher2.find()==true){
            String OLD_FORMAT = "MMM d yyyy";
            String NEW_FORMAT = "MM/dd/yyyy";
            String newDateString;
            SimpleDateFormat sdf = new SimpleDateFormat(OLD_FORMAT);
            Date d = sdf.parse(endDate);
            sdf.applyPattern(NEW_FORMAT);
            newDateString = sdf.format(d);
            System.out.println(newDateString);
        } else{
            System.out.println("invalid format");

        }
        }
}
