package string.ipaddress;

import java.util.*;

public class IpSorter {
    static Long toNumeric(String ip) {
        Scanner sc = new Scanner(ip).useDelimiter("\\.");
        
        return 
            (sc.nextLong() << 24) + 
            (sc.nextLong() << 16) + 
            (sc.nextLong() << 8) + 
            (sc.nextLong()); 
    }
    public static void main(String[] args) {
        Comparator<String> ipComparator = new Comparator<String>() {
            @Override public int compare(String ip1, String ip2) {
                return toNumeric(ip1).compareTo(toNumeric(ip2));
            }       
        };
        SortedSet<String> ips = new TreeSet<String>(ipComparator);
        ips.addAll(Arrays.asList(
            "192.168.0.1", "192.168.0.250", "192.168.0.9", "9.9.9.9"
        ));
        System.out.println(ips);
        // "[9.9.9.9, 192.168.0.1, 192.168.0.9, 192.168.0.250]"
    }
}

