package exercises;

import java.io.File;

public class Exercise28 {
	public static void main(String[] args) {

		for(int i = 0; i < args.length; i++) {
			File file = new File(args[i]);
			
			//check for privileges
			if (!file.exists() || !file.isFile() || !file.canWrite())
				continue;
			
			//matches only single digit names
			if (file.getName().matches("Exercise[0-9]_[0-9]+")) {
				String name = file.getName();
				StringBuilder newName = new StringBuilder();
				
				//inform the user about the progress
				System.out.println("Renaming file " + name);
				
				//construct a new name for the file
				for(int j = 0; j < name.length(); j++) {
					boolean isPadded = false;
					if (Character.isDigit(name.charAt(j)) && !isPadded) {
						newName.append(0).append(name.charAt(j));
						isPadded = true;
					}
					else
						newName.append(name.charAt(j));
				}
				
				if (file.renameTo(new File(newName.toString())))
					System.out.println("Renamed into: " + newName.toString());
				else
					System.out.println("Failed to rename a file " + file.getName());
			}		
		}
	}
}
