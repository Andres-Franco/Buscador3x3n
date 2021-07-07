/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscador3x3n;
import static java.lang.Math.abs;

/**
 *
 * @author Andres
 */
public class Buscador3x3n {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        double a = 0, b = 0, c = 0, d = 0, e = 0, f = 0, g = 0, h = 0, 
                i = 0, a11 = 1000, a12 = 0.005, a21 = 250, a13 = 0.004, a31 = 200, a22 = 1, 
                a23 = 0.9, a32 = 0.8, a33 = 1, l = 0, c1 = 0, c2 = 0, c3 = 0, 
                xn1 = 0, yn1 = 0, zn1 = 0, x = 0, y = 0, z = 0;
        double b1 = 1, b2 = 2, b3 = 3, r = 1, s = 1, t = 1, p = 0,detA=0,
                detx1=0,detx2=0,detx3=0,Cx_1=0,Cx_2=0,Cx_3=0,
                e1=0,e2=0,e3=0;
       
for (a11 = -10; a11 < 11; a11++) {
for (a12 = -10; a12 < 11; a12++) {
for (a13 = -10; a13 < 11; a13++) {
for (a21 = -10; a21 < 11; a21++) {
for (a22 = -10; a22 < 11; a22++) {
for (a23 = -10; a23 < 11; a23++) {
for (a31 = -10; a31 < 11; a31++) {
for (a32 = -10; a32 < 11; a32++) {
for (a33 = -10; a33 < 11; a33++) {
//Criterio de convergencia 
a = (1 / ((a11 + 1) * (a11 + 1))) * (1 + a12 * a21 + a13 * a31);

b = (-a12 / ((a11 + 1) * (a11 + 1))) - 
        (a12 * a21 * a12) / ((a11 + 1) * (a11 + 1)) - 
        (a12 * (1 - a22)) / (a11 + 1) - 
        (a13 * a31 * a12) / ((a11 + 1) * (a11 + 1)) + 
        (a13 * a32) / (a11 + 1);

c = (-a13 / ((a11 + 1) * (a11 + 1))) - 
        (a12 * a21 * a13) / ((a11 + 1) * (a11 + 1)) + 
        (a12 * a23) / (a11 + 1) - 
        (a13 * a31 * a13) / ((a11 + 1) * (a11 + 1)) - 
        (a13 * (1 - a33)) / (a11 + 1);
d = (-a21 / ((a11 + 1) * (a11 + 1))) - 
        (a21 * a12 * a21) / ((a11 + 1) * (a11 + 1)) - 
        (a21 * (1 - a22) / (a11 + 1)) + 
        ((a21 * a13 / (a11 + 1)) - a23) * (-a31 / (a11 + 1));
e = (a21 * a12 / ((a11 + 1) * (a11 + 1))) + 
        ((a21 * a12 / (a11 + 1)) + 
        (1 - a22)) * ((a21 * a12 / (a11 + 1)) + (1 - a22)) + 
        ((a21 * a13 / (a11 + 1)) - a23) * ((a31 * a12) / (a11 + 1) - a32);

f = (a21 * a13 / ((a11 + 1) * (a11 + 1))) + 
        ((a21 * a12) / (a11 + 1) + 
        (1 - a22)) * ((a21 * a13) / (a11 + 1) - a23) + 
        ((a21 * a13) / (a11 + 1) - a23) * ((a31 * a13) / (a11 + 1) + 
        (1 - a33));

g = (-a31 / ((a11 + 1) * (a11 + 1))) - 
        a21 / (a11 + 1) * ((a31 * a12) / (a11 + 1) - a32) - 
        (a31 / (a11 + 1)) * ((a31 * a13) / (a11 + 1) + (1 - a33));

h = (a31 * a12 / ((a11 + 1) * (a11 + 1))) + 
        ((a31 * a12) / (a11 + 1) - a32) * ((a21 * a12) / (a11 + 1) + 
        (1 - a22)) + ((a31 * a13) / (a11 + 1) + 
        (1 - a33)) * ((a31 * a12) / (a11 + 1) - a32);

i = (a31 * a13 / ((a11 + 1) * (a11 + 1))) + 
        ((a31 * a12 / (a11 + 1)) - a32) * ((a21 * a13 / (a11 + 1)) - a23) + 
        ((a31 * a13 / (a11 + 1)) + 
        (1 - a33)) * ((a31 * a13 / (a11 + 1)) + (1 - a33));

if ((a == 0) && (b == 0) && (c == 0) && (d == 0) && (e == 0) &&
        (f == 0) && (g == 0) && (h == 0) && (i == 0)) {
p = 0;
l++;
System.out.print("Ejemplo " + l + "\n" + "MATRIZ A " + "\n" + 
        "a11= " + a11 + "   " + "a12=" + a12 + "   " + "a13= " +
        a13 + "\n" + "a21= " + a21 + "   " + "a22= " + a22 +
        "   " + "a23= " + a23 + "\n" + "a31= " + a31 + "   " +
                "a32= " + a32 + "   " + "a33= " + a33 + "\n\n");



System.out.print("VECTOR b: " + "\n" + "b1= " + b1 + "\n"+
        "b2= " + b2 + "\n" + "b3= " + b3 + "\n\n");

//Método Cramer
detA = a11*a22*a33 + a21*a32*a13 + a31*a12*a23 - (a13*a22*a31 + a23*a32*a11 + 
        a33*a12*a21);
System.out.print("det(A):"+detA+ "\n\n");
detx1= b1*a22*a33 + b2*a32*a13 + b3*a12*a23 - (a13*a22*b3 + a23*a32*b1 + 
        a33*a12*b2);
detx2= a11*b2*a33 + a21*b3*a13 + a31*b1*a23 - (a13*b2*a31 + a23*b3*a11 + 
        a33*b1*a21);
detx3= a11*a22*b3 + a21*a32*b1+a31*a12*b2 -(b1*a22*a31 + b2*a32*a11 + 
        b3*a12*a21);

Cx_1= detx1/detA;
Cx_1 = Math.round(Cx_1 * 1000000000) / 1000000000.0;
Cx_2= detx2/detA;
Cx_2 = Math.round(Cx_2 * 1000000000) / 1000000000.0;
Cx_3= detx3/detA;
Cx_3 = Math.round(Cx_3 * 1000000000) / 1000000000.0;

//Método Franco
a = 1 / (a11 + 1);

a = Math.round(a * 1000000000) / 1000000000.0;

b = -a12 / (a11 + 1);
b = Math.round(b * 1000000000) / 1000000000.0;
c = -a13 / (a11 + 1);
c = Math.round(c * 1000000000) / 1000000000.0;
d = -a21 / (a11 + 1);
d = Math.round(d * 1000000000) / 1000000000.0;
e = (a21 * a12 / (a11 + 1)) + (1 - a22);
e = Math.round(e * 1000000000) / 1000000000.0;
f = (a21 * a13 / (a11 + 1)) - a23;
f = Math.round(f * 1000000000) / 1000000000.0;
g = -a31 / (a11 + 1);
g = Math.round(g * 1000000000) / 1000000000.0;
h = (a31 * a12 / (a11 + 1)) - a32;
h = Math.round(h * 1000000000) / 1000000000.0;
i = (a31 * a13 / (a11 + 1)) + (1 - a33);
i = Math.round(i * 1000000000) / 1000000000.0;

System.out.print("Inicio del Método: \n\n");
System.out.print("MATRIZ T = (^1P+I)^{-1}(I-(^2P+^3P)) " + "\n\n" + 
        "a= " + a + "  " + "b= " + b + "  " + "c= " + c + "\n" + "d= " + 
        d + "  " + "e= " + e + "  " + "f= " + f + "\n" + "g= " + g +
        "  " + "h= " + h + "  " + "i= " + i + "\n\n");
c1 = b1 / (a11 + 1);
c1 = Math.round(c1 * 1000000000) / 1000000000.0;
c2 = (-b1 * a21 / (a11 + 1)) + b2;
c2 = Math.round(c2 * 1000000000) / 1000000000.0;
c3 = (-b1 * a31 / (a11 + 1)) + b3;
c3 = Math.round(c3 * 1000000000) / 1000000000.0;

System.out.print("VECTOR c = (^1P+I)^{-1} b " + "\n\n" + "c1= " + 
        c1 + "\n" + "c2= " + c2 + "\n" + "c3= " + c3 + "\n\n");
while (true) {
p++;
xn1 = a * x + b * y + c * z + c1;
r = abs(x - xn1);
r = Math.round(r * 1000000000) / 1000000000.0;

yn1 = d * x + e * y + f * z + c2;
s = abs(y - yn1);
s = Math.round(s * 1000000000) / 1000000000.0;

zn1 = g * x + h * y + i * z + c3;
t = abs(z - zn1);
t = Math.round(t * 1000000000) / 1000000000.0;

x = xn1;
xn1 = Math.round(xn1 * 1000000000) / 1000000000.0;
y = yn1;
yn1 = Math.round(yn1 * 1000000000) / 1000000000.0;
z = zn1;
zn1 = Math.round(zn1 * 1000000000) / 1000000000.0;

System.out.print("Iteración Número:" + p +"    | "+
        "x_1 = "+xn1+" | "+"x_2 = "+yn1+" | "+"x_3 = "+zn1+"\n");
System.out.print("Orden de Convergencia:  | "+
        "x_1 = "+r+" | "+" x_2 = "+s+" | "+" x_3 = "+t+"\n\n\n");

if ((r == 0) && (s == 0) && (t == 0)) {
break;
                                                    }

                                                }

System.out.print("Cantidad de Iteraciones " + p + "\n\n" + "SOLUCIÓN FRANCO: " +
"\n"+"x_1 = "+xn1+" | "+"x_2 = "+yn1+" | "+"x_3 = "+zn1+"\n\n");
System.out.print("SOLUCIÓN CRAMER: "+"\n"+"x_1= "+Cx_1+" | "+" x_2= "+Cx_2+" | "
        +" x_3= "+Cx_3+"\n\n");
//Calculo Error
e1=abs((Cx_1-xn1)/Cx_1)*100;
e2=abs((Cx_2-yn1)/Cx_2)*100;
e3=abs((Cx_3-zn1)/Cx_3)*100;
System.out.print("Error relativo respecto a Cramer en porcentaje: "+" Ex1: " 
        +e1+" | "+" Ex2: "+e2+" | "+" Ex3: "+e3+"\n\n\n\n" );
                                            }
                                        }
                                   }

                                }

                            }

                        }
                    }

                }
            }
        }
    }

}
    
