package io.github.vcvitaly.limestone;

import java.util.*;

public class Task {

    public static void main(String[] args) {
        new Task().days(34);
    }

    public String days(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("Provided arguments should be >= 0");
        }

        List<Integer> list = new ArrayList<>();
        while (i > 0) {
            int e = i % 10;
            if (e <= 0 || e > 7) {
                throw new IllegalArgumentException("Only digits 1-7 are valid");
            }
            list.add(e);
            i /= 10;
        }

        if (list.size() == 1) {
            return String.valueOf(list.get(0));
        }

        Collections.reverse(list);
        StringBuilder sb = new StringBuilder();
        sb.append(list.get(0));

        String buf = "";
        for (int j = 1; j < list.size(); j++) {
            int digit = list.get(j);

            if (digit - 1 == list.get(j-1)) {
                buf = "-" + digit;
            } else {
                sb.append(buf).append("," + digit);
                buf = "";
            }
        }
        sb.append(buf);

        return sb.toString();
    }
}
