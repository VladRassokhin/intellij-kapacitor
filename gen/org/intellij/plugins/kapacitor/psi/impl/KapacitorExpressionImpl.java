// This is a generated file. Not intended for manual editing.
package org.intellij.plugins.kapacitor.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.intellij.plugins.kapacitor.KapacitorElementTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.intellij.plugins.kapacitor.psi.*;

public class KapacitorExpressionImpl extends ASTWrapperPsiElement implements KapacitorExpression {

  public KapacitorExpressionImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull KapacitorElementVisitor visitor) {
    visitor.visitExpression(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof KapacitorElementVisitor) accept((KapacitorElementVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public KapacitorPrimaryFunc getPrimaryFunc() {
    return findChildByClass(KapacitorPrimaryFunc.class);
  }

  @Override
  @Nullable
  public KapacitorStringList getStringList() {
    return findChildByClass(KapacitorStringList.class);
  }

  @Override
  @NotNull
  public List<KapacitorChain> getChainList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, KapacitorChain.class);
  }

  @Override
  @Nullable
  public KapacitorFunction getFunction() {
    return findChildByClass(KapacitorFunction.class);
  }

  @Override
  @Nullable
  public KapacitorIdentifier getIdentifier() {
    return findChildByClass(KapacitorIdentifier.class);
  }

  @Override
  @NotNull
  public List<KapacitorLiteral> getLiteralList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, KapacitorLiteral.class);
  }

  @Override
  @Nullable
  public KapacitorPrimaryExpr getPrimaryExpr() {
    return findChildByClass(KapacitorPrimaryExpr.class);
  }

  @Override
  @Nullable
  public KapacitorPrimaryUnaryExpr getPrimaryUnaryExpr() {
    return findChildByClass(KapacitorPrimaryUnaryExpr.class);
  }

}
