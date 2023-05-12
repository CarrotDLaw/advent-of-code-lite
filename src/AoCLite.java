import java.util.*;
import java.io.*;

public class AoCLite {
  static Scanner sc = new Scanner(System.in);
  static String rootDir = System.getProperty("user.dir");

  public AoCLite() {
  }

  public static void day01Lite() {
    List<Integer> fruitIntList = new ArrayList<>();
    String listDir = rootDir.concat("/input/AoCLiteDay01.txt");
    try (BufferedReader fruitList = new BufferedReader(new FileReader(listDir))) {
      String fruitString = fruitList.readLine();
      while (fruitString != null) {
        fruitIntList.add(Integer.parseInt(fruitString));
        fruitString = fruitList.readLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    int sum1 = 0; // part 1
    int sum2 = 0; // part 2
    int elimination = 0;
    for (int i : fruitIntList) {
      sum1 += i;
      sum2 += i;
      if (sum2 % 10 == 0) {
        sum2 /= 10;
        elimination++;
      }
    }
    System.out.println(sum1);
    System.out.println(sum2 * elimination);
  }

  public static void day02Lite() {
    List<Integer> coinIntList = new ArrayList<>();
    String listDir = rootDir.concat("/input/AoCLiteDay02.txt");
    try (BufferedReader coin = new BufferedReader(new FileReader(listDir))) {
      String coinsString = coin.readLine();
      while (coinsString != null) {
        coinIntList.add(Integer.parseInt(coinsString));
        coinsString = coin.readLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    int sum1 = 0; // part 1
    int sum2 = 0; // part 2
    for (int i : coinIntList) {
      if (i % 10 != 0) {
        sum1 += i;
        if (!(String.valueOf(Integer.toString(i)).contains("0"))) {
          sum2 += i;
        }
      }
    }
    System.out.println(sum1);
    System.out.println(sum2);
  }

  public static void day03Lite() {
    List<String> cmdStrList = new ArrayList<>();
    String listDir = rootDir.concat("/input/AoCLiteDay03.txt");
    try (BufferedReader reader = new BufferedReader(new FileReader(listDir))) {
      String cmdStr = reader.readLine();
      while (cmdStr != null) {
        cmdStrList.add(cmdStr);
        cmdStr = reader.readLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    int checksum = 0;
    for (String str : cmdStrList) { // part 1
      if (str.equals("inc")) {
        checksum += 1;
      } else if (str.equals("dbl")) {
        checksum *= 2;
      }
    }
    System.out.println(checksum);
    checksum = 0;
    for (String str : cmdStrList) { // part 2
      if (str.equals("inc")) {
        checksum += 1;
      } else if (str.equals("dbl")) {
        checksum *= 2;
      } else if (str.equals("dec")) {
        checksum -= 1;
      } else if (str.equals("hlf")) {
        checksum /= 2;
      } else if (str.equals("out")) {
        System.out.print((char) checksum);
      }
    }
    System.out.println();
  }

  public static void day04Lite() {
    List<String> dataStrList = new ArrayList<>();
    List<String> correctedDataStrList = new ArrayList<>();
    String listDir = rootDir.concat("/input/AoCLiteDay04.txt");
    try (BufferedReader data = new BufferedReader(new FileReader(listDir))) {
      String dataStr = data.readLine();
      int sum = 0;
      while (dataStr != null) {
        dataStrList.add(dataStr);
        dataStr = data.readLine();
      }
      for (String i : dataStrList) { // part 1
        if (i.charAt(0) == '0') {
          correctedDataStrList.add(i);
        }
      }
      System.out.println(correctedDataStrList.size());
      for (String i : correctedDataStrList) { // part 2
        sum += Integer.parseInt(i.toString(), 2);
      }
      System.out.println(sum);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void day05Lite() {
    List<String> moveStrList = new ArrayList<>();
    String listDir = rootDir.concat("/input/AoCLiteDay05.txt");
    try (BufferedReader moves = new BufferedReader(new FileReader(listDir))) {
      String movesStr = moves.readLine();
      int sum = 0;
      int vSum = 0;
      int hSum = 0;
      while (movesStr != null) {
        moveStrList.add(movesStr);
        movesStr = moves.readLine();
      }
      for (String str : moveStrList) { // part 1
        if (str.equals(">")) {
          sum += 1;
        } else if (str.equals(">>")) {
          sum += 5;
        } else if (str.equals("<")) {
          sum -= 1;
        } else if (str.equals("<<")) {
          sum -= 5;
        }
      }
      System.out.println(sum);
      for (String str : moveStrList) { // part 2
        if (str.equals(">")) {
          hSum += 1;
        } else if (str.equals(">>")) {
          vSum += 1;
        } else if (str.equals("<")) {
          hSum -= 1;
        } else if (str.equals("<<")) {
          vSum -= 1;
        }
      }
      System.out.println(Math.abs(vSum) * 1000 + Math.abs(hSum));
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void day06Lite() {
    List<Integer> lengthList = new ArrayList<>();
    List<Integer> widthList = new ArrayList<>();
    List<Integer> heightList = new ArrayList<>();
    String listDir = rootDir.concat("/input/AoCLiteDay06.txt");
    String dimensionsStr = null;
    try (BufferedReader dimensions = new BufferedReader(new FileReader(listDir))) {
      dimensionsStr = dimensions.readLine();
      while (dimensionsStr != null) {
        String[] dimensionsStrAry = dimensionsStr.split(",");
        lengthList.add(Integer.parseInt(dimensionsStrAry[0]));
        widthList.add(Integer.parseInt(dimensionsStrAry[1]));
        heightList.add(Integer.parseInt(dimensionsStrAry[2]));
        dimensionsStr = dimensions.readLine();
      }
      int sum = 0;
      for (int i : heightList) { // part 1
        sum += i;
      }
      int vol = 0;
      for (int i = 0; i < lengthList.size(); i++) { // part 2
        vol += (lengthList.get(i) * widthList.get(i) * heightList.get(i));
      }
      System.out.println(sum);
      System.out.println(vol);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    day01Lite();
    day02Lite();
    day03Lite();
    day04Lite();
    day05Lite();
    day06Lite();
  }
}
