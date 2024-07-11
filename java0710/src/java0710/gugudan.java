package java0710;

public class gugudan {
    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            // 구구단 한 줄을 저장할 문자열
            StringBuilder line = new StringBuilder();
            
            // 각 구구단의 곱셈 결과를 추가
            for (int j = 2; j <= 9; j++) {
                line.append(j).append(" * ").append(i).append(" = ").append(j*i);
                // 구구단 사이에 구분선을 추가
                if (j != 9) {
                    line.append("\t"); // 탭으로 구분
                }
            }
            
            // 한 줄 출력
            System.out.println(line.toString());
        }
    }
}
