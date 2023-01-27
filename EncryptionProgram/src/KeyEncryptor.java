import java.util.Random;

public class KeyEncryptor {
	
	private static char[] initialKey;
	private char[] encryptedKey;
	private static char[] stringToChar;
	private String encryptedM;
	private String decryptedM;
	
	KeyEncryptor(){
		
		stringToChar = new char[94];
		
		encryptedKey = new char[94];
		initialKey = new char[94];
		
		for(int i=33,j=0; i<127;i++,j++) {
			encryptedKey[j] = (char)i;
			initialKey[j] = (char)i;
		}
		
		newKeyGenerator();
		System.out.println("A new key has been generated:");
		printKey();
	}
	
/**/public void newKeyGenerator() {
		
		Random random = new Random();
		int check;
		
		for(int i = 0; i<94;i++) {

			check = (i + random.nextInt(94 - i));
			
			swapper(i , check);	
		}
		
	}

/**/private void swapper(int i, int check) {
	
	int a = encryptedKey[i];
	
	encryptedKey[i] = encryptedKey[check];
	encryptedKey[check] = (char) a;
	
}

/**/public void printKey() {
	
	/*for(int i = 0;i<94;i++) {
		System.out.print(initialKey[i]);
	}
	
	System.out.println();*/
	
	for(int i = 0;i<94;i++) {
		System.out.print(encryptedKey[i]);
	}
	
	System.out.println();
}
	
/**/public void encrypt(String message) {
		
		encryptedM = "";
		
		for (int i = 0; i<message.length(); i++) {
			stringToChar[i] = message.charAt(i);
		}
		
		for(int j = 0; j < message.length(); j++) {
			
			for (int i = 0; i<94; i++) {
				if (message.charAt(j) == initialKey[i]) {
					stringToChar[j] = encryptedKey[i];
					break;
				}
			}
		}
		
		for (int i = 0; i<message.length(); i++) {
			encryptedM = encryptedM + stringToChar[i];
			stringToChar[i] = ' ';
		}
		
	}

/**/public String getEncryptedMessage() {
	return encryptedM;
}
	
/**/public void decrypt() {
		
		decryptedM = "";
		
		for (int i = 0; i<encryptedM.length(); i++) {
			stringToChar[i] = encryptedM.charAt(i);
		}
		
		for(int j = 0; j < encryptedM.length(); j++) {
			
			for (int i = 0; i<94; i++) {
				if (encryptedM.charAt(j) == encryptedKey[i]) {
					stringToChar[j] = initialKey[i];
					break;
				}
			}
		}
		
		for (int i = 0; i<encryptedM.length(); i++) {
			decryptedM = decryptedM + stringToChar[i];
			stringToChar[i] = ' ';
		}
		
	}

/**/public String getDecryptedMessage() {
		return decryptedM;
	}

}
