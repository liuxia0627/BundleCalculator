import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * @author rogerwill
 * Jave Bean to represent the submission:
 * Submission format | Format code | Bundles
 * ----------------- | ----------- | -------
 *        Image      |     IMG     | 5 @ $450 10 @ $800
 */
public class Submission {
	
	private String format;
	
	private String formateCode;
	
	private List<Bundle> bundles;

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getFormateCode() {
		return formateCode;
	}

	public void setFormateCode(String formateCode) {
		this.formateCode = formateCode;
	}

	public List<Bundle> getBundles() {
		return bundles;
	}

	public void setBundles(List<Bundle> bundles) {
		this.bundles = bundles;
	}

	public Submission() {
		
	}
	
	public Submission(String format, String formateCode, List<Bundle> bundles) {
		this.format = format;
		this.formateCode = formateCode;
		this.bundles = bundles;
	}
	
	public Submission(String format, String formateCode, String bundlesStr) {
		List<Bundle> bundles = new ArrayList<Bundle>();
		String[] bundleArr = bundlesStr.split(";");
		int amount;
		String priceStr;
		double price;
//		System.out.println("format: " + format);
//		System.out.println("formateCode: " + formateCode);
		for(String bundleStr:bundleArr) {
//			System.out.println("bundleStr: " + bundleStr);
			amount = Integer.valueOf(bundleStr.split("\\@")[0].trim());
			priceStr = bundleStr.split("\\@")[1].trim();
			price = Double.valueOf(priceStr.substring(1));
//			System.out.println("amount: " + amount);
//			System.out.println("price: " + price);
			bundles.add(new Bundle(amount,price));
		}
		this.format = format;
		this.formateCode = formateCode;
		this.bundles = bundles;
	}
	
	
}
