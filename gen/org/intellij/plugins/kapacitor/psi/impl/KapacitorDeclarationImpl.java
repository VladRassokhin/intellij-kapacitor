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

public class KapacitorDeclarationImpl extends ASTWrapperPsiElement implements KapacitorDeclaration {

  public KapacitorDeclarationImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull KapacitorElementVisitor visitor) {
    visitor.visitDeclaration(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof KapacitorElementVisitor) accept((KapacitorElementVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public KapacitorExpression getValue() {
    List<KapacitorExpression> p1 = PsiTreeUtil.getChildrenOfTypeAsList(this, KapacitorExpression.class);
    return p1.size() < 2 ? null : p1.get(1);
  }

  @NotNull
  public KapacitorIdentifier getVariable() {
    return KapacitorPsiImplUtilJ.getVariable(this);
  }

}
