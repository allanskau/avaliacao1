
import utfpr.ct.dainf.if62c.avaliacao.Complexo;

/**
 * UTFPR - Universidade Tecnológica Federal do Paraná DAINF - Departamento
 * Acadêmico de Informática IF62C - Fundamentos de Programação 2
 *
 * Primeira avaliação parcial 2014/2.
 *
 * @author
 */
public class Avaliacao1 {

    // implementar main

    public static void main(String[] args) {
        // x² + 5*x + 4 + = 0
        Complexo a = new Complexo(1, 0);
        Complexo b = new Complexo(5, 0);
        Complexo c = new Complexo(4, 0);
        Complexo[] raizes = raizesEquacao(a, b, c);
        System.out.println("raizes de: x² + 5*x + 4 = 0 :");
        System.out.println("x1=" + raizes[0]);
        System.out.println("x2=" + raizes[1]);

        //System.out.println("a + b = " + a.soma(b));        
        //System.out.println("a - c = " + a.sub(c));
        //System.out.println("a * c = " + a.prod(c));
        //System.out.println("a / b = " + a.div(b));
        //System.out.println("a * 3 = " + a.prod(3));
        //System.out.println("a.sqrt()[0] = " + raizes[0] + " -- a.sqrt()[1]" + raizes[1]);
        // y² + 2y + 5 = 0
        a = new Complexo(1, 0);
        b = new Complexo(2, 0);
        c = new Complexo(5, 0);
        raizes = raizesEquacao(a, b, c);
        System.out.println("raizes de: y² + 2*x + 5 = 0 :");
        System.out.println("x1=" + raizes[0]);
        System.out.println("x2=" + raizes[1]);

    }

    // implementar raizesEquacao(Complexo, Complexo, Complexo)
    public static Complexo[] raizesEquacao(Complexo a, Complexo b, Complexo c) {
        Complexo[] raizesEquacao = new Complexo[2];
        Complexo[] delta;
        delta = ((b.prod(b)).sub((a.prod(c)).prod(4))).sqrt();
        //System.out.println("delta[0] = " + delta[0]);
        //System.out.println("delta[1] = " + delta[1]);
        raizesEquacao[0] = ((b.prod(-1)).soma(delta[0])).div(a.prod(2));
        raizesEquacao[1] = ((b.prod(-1)).soma(delta[1])).div(a.prod(2));

        return raizesEquacao;
    }
}
