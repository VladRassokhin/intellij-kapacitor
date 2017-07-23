// This is a generated file. Not intended for manual editing.
package org.intellij.plugins.tickscript.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.intellij.plugins.tickscript.KapacitorElementTypes.*;
import org.intellij.plugins.tickscript.psi.*;
import com.intellij.psi.tree.IElementType;

public class KapacitorBinaryExpressionImpl extends BinaryExpressionMixin implements KapacitorBinaryExpression {

  public KapacitorBinaryExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull KapacitorElementVisitor visitor) {
    visitor.visitBinaryExpression(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof KapacitorElementVisitor) accept((KapacitorElementVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public KapacitorExpression getLOperand() {
    List<KapacitorExpression> p1 = PsiTreeUtil.getChildrenOfTypeAsList(this, KapacitorExpression.class);
    return p1.get(0);
  }

  @Override
  @Nullable
  public KapacitorExpression getROperand() {
    List<KapacitorExpression> p1 = PsiTreeUtil.getChildrenOfTypeAsList(this, KapacitorExpression.class);
    return p1.size() < 2 ? null : p1.get(1);
  }

  @NotNull
  public IElementType getOperationSign() {
    return KapacitorPsiImplUtilJ.getOperationSign(this);
  }

}
