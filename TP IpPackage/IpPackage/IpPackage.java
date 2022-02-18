package IpPackage;

public class IpPackage {
  private int octet1;
  
  private int octet2;
  
  private int octet3;
  
  private int octet4;
  
  private IpPackage(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    this.octet1 = paramInt1;
    this.octet2 = paramInt2;
    this.octet3 = paramInt3;
    this.octet4 = paramInt4;
  }
  
  public IpPackage(int i, int j, int k, boolean bool) {
  }

  public void test() {
    System.out.println("Hello World Package OK ? ");
  }
  
  public static IpPackage getInstance(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {
    try {
      if (paramInt1 < 0 || paramInt1 > 255 || paramInt2 < 0 || paramInt2 > 255 || paramInt3 < 0 || paramInt3 > 255 || paramInt4 < 0 || paramInt4 > 255)
        throw new Exception(); 
    } catch (Exception exception) {
      System.out.println("Valeur impossible \n");
    } 
    System.out.println("o1 = " + paramInt1);
    System.out.println("o2 = " + paramInt2);
    System.out.println("o3 = " + paramInt3);
    System.out.println("o4 = " + paramInt4);
    return new IpPackage(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public String ToString() {
    return "o1 = " + this.octet1 + " o2 = " + this.octet2 + " o3 = " + this.octet3 + " o4 = " + this.octet4;
  }
  
  public int getOctet1() {
    return this.octet1;
  }
  
  public int getOctet2() {
    return this.octet2;
  }
  
  public int getOctet3() {
    return this.octet3;
  }
  
  public int getOctet4() {
    return this.octet4;
  }
  
  public char getClasse() {
    byte b = 120;
    if (this.octet1 <= 126)
      b = 65; 
    if (this.octet1 >= 126 && this.octet1 <= 191)
      b = 66; 
    if (this.octet1 >= 192 && this.octet1 <= 223)
      b = 67; 
    return (char)b;
  }
  
  public IpPackage adresseReseau() {
    int i = this.octet1;
    int j = 0;
    int k = 0;
    boolean bool = false;
    if (getClasse() == 'B')
      j = this.octet2; 
    if (getClasse() == 'C') {
      j = this.octet2;
      k = this.octet3;
    } 
    return new IpPackage(i, j, k, bool);
  }
  
  public Boolean estMemeReseau(IpPackage paramIpPackage) {
    return Boolean.valueOf(((adresseReseau()).octet1 == (paramIpPackage.adresseReseau()).octet1 && 
        (adresseReseau()).octet2 == (paramIpPackage.adresseReseau()).octet2 && 
        (adresseReseau()).octet3 == (paramIpPackage.adresseReseau()).octet3));
  }
}