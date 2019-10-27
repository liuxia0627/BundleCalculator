import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * @author rogerwill
 * Jave Bean represents the output result
 */
public class Output {
	
	private String formateCode;
	
	private Integer amount;
	
	private Double totalPrice;
	
	private TreeMap<Bundle,Integer> bundles;

	public String getFormateCode() {
		return formateCode;
	}

	public void setFormateCode(String formateCode) {
		this.formateCode = formateCode;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public TreeMap<Bundle,Integer> getBundles() {
		return bundles;
	}

	public void setBundles (TreeMap<Bundle,Integer> bundles) {
		this.bundles = bundles;
	}

	public Output() {
		super();
	}

	public Output(String formateCode, Integer amount, Double totalPrice, TreeMap<Bundle,Integer> bundles) {
		this.formateCode = formateCode;
		this.amount = amount;
		this.totalPrice = totalPrice;
		this.bundles = bundles;
	}

	@Override
	public String toString() {
		return amount + " " + formateCode + " $" + totalPrice + System.getProperty("line.separator") + printBundles();
	}
	
	public String printBundles() {
		StringBuilder bundlesSb = new StringBuilder();
		if (bundles.size() > 0) {
			for(Bundle bundle : bundles.descendingKeySet()){
				bundlesSb.append(" " + bundles.get(bundle) + " x " + bundle.getAmount() + " $"
						+ (bundles.get(bundle) * bundle.getPrice() + System.getProperty("line.separator")));
			}
		}
		return bundlesSb.toString();
	}
	
}
