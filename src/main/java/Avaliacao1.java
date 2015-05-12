
import utfpr.ct.dainf.if62c.avaliacao.Complexo;

/**
 * UTFPR - Universidade Tecnológica Federal do Paraná
 * DAINF - Departamento Acadêmico de Informática
 * IF62C - Fundamentos de Programação 2
 * 
 * Primeira avaliação parcial 2014/2.
 * @author 
 */
public class Avaliacao1 {
    
    public static Complexo[] raizesEquacao(Complexo a, Complexo b, Complexo c){
        Complexo[] raizesEquacao = new Complexo[2];
        //raizesEquacao = sqrt(b);
        //raizesEquacao = sqrt(((b.prod(b)).sub(a.prod(c).prod(4))));
        //raizesEquacao[0] = (b.prod(-1).soma((b.prod(b)).sub(a.prod(c).prod(4))));
        raizesEquacao[0] = b.prod(-1).soma(raizesEquacao[0]).div(a.prod(2));
        raizesEquacao[1] = b.prod(-1).soma(raizesEquacao[1]).div(a.prod(2));
        
        return raizesEquacao;
    }
    public static void main(String[] args) {
        // implementar main
    }
    
    // implementar raizesEquacao(Complexo, Complexo, Complexo)
    
}
