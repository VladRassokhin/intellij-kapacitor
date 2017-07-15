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

public class KapacitorStatementImpl extends ASTWrapperPsiElement implements KapacitorStatement {

  public KapacitorStatementImpl(ASTNode node) {
    super(node);
  }

  public void accept(@NotNull KapacitorElementVisitor visitor) {
    visitor.visitStatement(this);
  }

  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof KapacitorElementVisitor) accept((KapacitorElementVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public KapacitorDeclaration getDeclaration() {
    return findChildByClass(KapacitorDeclaration.class);
  }

  @Override
  @Nullable
  public KapacitorExpression getExpression() {
    return findChildByClass(KapacitorExpression.class);
  }

  @Override
  @Nullable
  public KapacitorTypeDeclaration getTypeDeclaration() {
    return findChildByClass(KapacitorTypeDeclaration.class);
  }

}
