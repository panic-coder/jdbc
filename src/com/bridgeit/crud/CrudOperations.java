/**
 * Purpose: Create 
 * 
 * @author Kumar Shubham
 * @since 23/06/2018
 *
 */
package com.bridgeit.crud;

import com.bridgeit.model.Info;
import com.bridgeit.utility.Utility;

public class CrudOperations {
	public static void main(String[] args) {
		Utility utility = new Utility();
		
		String databaseName="";
		
			System.out.println("1. Create new database\n"
					+ "2. Open Existing database\n"
					+ "3. Drop a database");
			int choice = utility.inputInteger(); 
			switch(choice) {
			case 1:
				System.out.println("Enter the name of the database");
				databaseName = utility.inputString();
				utility.createDatabase(databaseName);
				break;
			case 2:
				System.out.println("Enter the name of the existing database");
				databaseName = utility.inputString();
				utility.openExistingDatabase(databaseName);
				int loopOperations = 0;
				while(loopOperations==0) {
					System.out.println("1. Create table\n"
							+ "2. Update tables\n"
							+ "3. Delete table\n"
							+ "4. Close database menu");
					int choiceOperations = utility.inputInteger();
					switch(choiceOperations) {
					case 1:
						System.out.println("Enter the name of the table");
						String tableNew = utility.inputString();
						utility.createTable(tableNew,databaseName);
						break;
					case 2:
						int loopUpdates=0;
						while(loopUpdates==0) {
							System.out.println("1. Display\n"
									+ "2. Insert\n"
									+ "3. Delete\n"
									+ "4. Update\n"
									+ "5. Close");
							int choiceUpdates = utility.inputInteger();
							switch(choiceUpdates) {
							case 1:
								utility.display(databaseName);
								break;
							case 2:
								Info info = new Info();
								System.out.println("Enter id");
								info.setId(utility.inputInteger());
								System.out.println("Enter first name");
								info.setFirstName(utility.inputString()); ;
								System.out.println("Enter last name");
								info.setLastName(utility.inputString());;
								System.out.println("Enter gender");
								info.setGender(utility.inputString());;
								System.out.println("Enter marital status");
								info.setMaritalStatus(utility.inputString());;
								utility.insert(info,databaseName);
								break;
							case 3:
								utility.delete(databaseName);
								break;
							case 4:
								utility.update(databaseName);
								break;
							case 5:
								loopUpdates=1;
								System.out.println("Menu Closed");
								break;
							default:
								loopUpdates=1;
								System.out.println("Wrong choice");
								break;
							}
						}
						utility.updateTables(databaseName);
						break;
					case 3:
						break;
					case 4:
						choiceOperations=1;
						break;
					default:
						choiceOperations=1;
						break;
					}
				}
				break;
			case 3:
				System.out.println("Enter the name of the database to drop");
				databaseName = utility.inputString();
				utility.dropDatabase(databaseName);
				break;
			default:
				System.out.println("Wrong Choice");
				break;
			}
			
		
	}
}
