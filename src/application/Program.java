package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PayPalService;

public class Program {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Enter contact data ");
		System.out.print("Number: ");
		int numberContract = sc.nextInt();
		System.out.print("Date (DD/MM/YYYY): ");
		Date dateContract = sdf.parse(sc.next());
		System.out.print("Contract value: ");
		double valueContract = sc.nextDouble();

		Contract contract1 = new Contract(numberContract, dateContract, valueContract);

		System.out.print("Enter number os installments: ");
		int installmentsContract = sc.nextInt();

		ContractService cs = new ContractService(new PayPalService());

		cs.processContract(contract1, installmentsContract);

		System.out.println("Installments: ");
		for (Installment it : contract1.getInstallments()) {
			System.out.println(it);
		}

		sc.close();

	}

}
