// This is a generated file. Not intended for manual editing.
package org.intellij.plugins.kapacitor.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.intellij.plugins.kapacitor.KapacitorElementTypes.*;
import org.intellij.plugins.kapacitor.psi.*;

public class KapacitorChainAtExpressionImpl extends KapacitorChainExpressionImpl implements KapacitorChainAtExpression {

  public KapacitorChainAtExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull KapacitorElementVisitor visitor) {
    visitor.visitChainAtExpression(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof KapacitorElementVisitor) accept((KapacitorElementVisitor)visitor);
    else super.accept(visitor);
  }

}
