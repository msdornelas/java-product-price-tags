package entities;

public final class ImportedProduct extends Product {

	private Double customsFee;

	public ImportedProduct() {
	}

	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}

	public Double totalPrice() {
		return super.getPrice() + this.getCustomsFee();
	}

	@Override
	public String toString() {
		return super.getName() + " $ " + String.format("%.2f", super.getPrice()) + " (Customs fee: $ "
				+ String.format("%.2f", this.getCustomsFee()) + ")";
	}
}
