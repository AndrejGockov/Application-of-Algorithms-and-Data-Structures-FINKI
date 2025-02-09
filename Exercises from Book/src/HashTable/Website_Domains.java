package HashTable;

import java.util.Scanner;

public class Website_Domains {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        CBHT<String, Integer>domains = new CBHT<>(n * 2);

        for(int i = 0; i < n; i++){
            int number = input.nextInt();
            String site = input.next();
            String[] domain = site.split("\\.");

            domains.insert(site, number);
            String domainBuilder = "";

            for(int j = 1; j < domain.length; j++){
                domainBuilder += domain[j];
                if(j != domain.length - 1)
                    domainBuilder+= ".";

                SLLNode<MapEntry<String, Integer>>node = domains.search(domainBuilder);
                domains.insert(domain[j], number);
            }
        }

        System.out.println(domains);
        int m = input.nextInt();

        for(int i = 0; i < m; i++){
            String site = input.next();
            int sum = 0;
        }
    }
}
