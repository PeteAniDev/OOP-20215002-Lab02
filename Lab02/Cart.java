
public class Cart {

	public static final int MAX_NUMBERS_ORDERED = 20;

	private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered = 0;

	public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
		for (DigitalVideoDisc dvd : dvds) {
			addDigitalVideoDisc(dvd);
		}
	}

	public void addDigitalVideoDisc(DigitalVideoDisc dvd) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED - 2) {
			itemsOrdered[qtyOrdered++] = dvd;
			System.out.println(dvd.getTitle() + " has been added.");
		} else if (qtyOrdered < MAX_NUMBERS_ORDERED - 1) {
			itemsOrdered[qtyOrdered++] = dvd;
			System.out.println(dvd.getTitle() + " has been added, the cart is almost full.");
		} else if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered++] = dvd;
			System.out.println(dvd.getTitle() + " has been added, the cart is now full.");
		} else {
			System.out.println("Failed to add " + dvd.getTitle() + " to cart, the cart is already full.");
		}
	}

	public void removeDigitalVideoDisc(DigitalVideoDisc dvd) {
		int removed = MAX_NUMBERS_ORDERED;
		for (int i = 0; i < qtyOrdered; i++) {
			if (itemsOrdered[i] == dvd) {
				removed = i;
				break;
			}
		}
		for (int i = removed; i < qtyOrdered; i++) {
			itemsOrdered[i] = (i == MAX_NUMBERS_ORDERED - 1) ? null : itemsOrdered[i + 1];
		}
		if (removed != MAX_NUMBERS_ORDERED) {
			qtyOrdered--;
			System.out.println(dvd.getTitle() + " has been removed.");
		} else {
			System.out.println("Your cart doesn't have " + dvd.getTitle());
		}
	}

	public float totalCost() {
		float total = 0;
		for (int i = 0; i < qtyOrdered; i++) {
			total += itemsOrdered[i].getCost();
		}
		return total;
	}

}
