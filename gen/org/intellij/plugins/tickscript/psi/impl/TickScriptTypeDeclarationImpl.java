// This is a generated file. Not intended for manual editing.
package org.intellij.plugins.tickscript.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static org.intellij.plugins.tickscript.TickScriptElementTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import org.intellij.plugins.tickscript.psi.*;

public class TickScriptTypeDeclarationImpl extends ASTWrapperPsiElement implements TickScriptTypeDeclaration {

  public TickScriptTypeDeclarationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull TickScriptElementVisitor visitor) {
    visitor.visitTypeDeclaration(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof TickScriptElementVisitor) accept((TickScriptElementVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public TickScriptIdentifier getVariable() {
    List<TickScriptIdentifier> p1 = PsiTreeUtil.getChildrenOfTypeAsList(this, TickScriptIdentifier.class);
    return p1.get(0);
  }

  @Override
  @Nullable
  public TickScriptIdentifier getType() {
    List<TickScriptIdentifier> p1 = PsiTreeUtil.getChildrenOfTypeAsList(this, TickScriptIdentifier.class);
    return p1.size() < 2 ? null : p1.get(1);
  }

}
