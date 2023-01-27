import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);		
		KeyEncryptor key = new KeyEncryptor();
		
		String option = " ";
		String message;
		
		while (option.charAt(0) != 'Q') {
			
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Choose the appropriate keys for the tasks you want to perform:");
			System.out.println("N: Generate a new key, E = Encrypt your message, P = Print the encrypted message D = Decrypt and print your message, Q = Quit");
			
			option = scanner.nextLine();
			option = option.toUpperCase();
			
			if (option.isEmpty()) {
				option = "-";
			}
			
			switch (option.charAt(0)) {
				case 'N': 
					System.out.println();
					key.newKeyGenerator();
				  	System.out.println("A new key has been generated:");
				  	key.printKey();
				  	break;
				case 'E':
					System.out.println("Please type the message you want to encrypt:");
					message = scanner.nextLine();
					key.encrypt(message);
					System.out.println("Your message has been encrypted");
					break;
				case 'P':
					System.out.println(key.getEncryptedMessage());
					break;
				case 'D':
					key.decrypt();
					System.out.println("Your message has been decrypted.");
					System.out.println(key.getDecryptedMessage());
					break;
				case 'Q':
					break;
				default:
					System.out.println("Please type in the correct response!");
					break;
					
			}
			
			System.out.println();
			
		}

		scanner.close();

	}


}
