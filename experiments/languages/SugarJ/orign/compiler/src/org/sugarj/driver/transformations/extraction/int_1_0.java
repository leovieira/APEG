package org.sugarj.driver.transformations.extraction;

import org.strategoxt.stratego_lib.*;
import org.strategoxt.lang.*;
import org.spoofax.interpreter.terms.*;
import static org.strategoxt.lang.Term.*;
import org.spoofax.interpreter.library.AbstractPrimitive;
import java.util.ArrayList;
import java.lang.ref.WeakReference;

@SuppressWarnings("all") public class int_1_0 extends Strategy 
{ 
  public static int_1_0 instance = new int_1_0();

  @Override public IStrategoTerm invoke(Context context, IStrategoTerm term, Strategy u_29)
  { 
    ITermFactory termFactory = context.getFactory();
    context.push("int_1_0");
    Fail278:
    { 
      IStrategoTerm m_149 = null;
      IStrategoTerm l_149 = null;
      if(term.getTermType() != IStrategoTerm.APPL || ext_out._consint_1 != ((IStrategoAppl)term).getConstructor())
        break Fail278;
      l_149 = term.getSubterm(0);
      IStrategoList annos229 = term.getAnnotations();
      m_149 = annos229;
      term = u_29.invoke(context, l_149);
      if(term == null)
        break Fail278;
      term = termFactory.annotateTerm(termFactory.makeAppl(ext_out._consint_1, new IStrategoTerm[]{term}), checkListAnnos(termFactory, m_149));
      context.popOnSuccess();
      if(true)
        return term;
    }
    context.popOnFailure();
    return null;
  }
}