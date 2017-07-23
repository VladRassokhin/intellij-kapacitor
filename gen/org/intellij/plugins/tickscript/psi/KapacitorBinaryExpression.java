// This is a generated file. Not intended for manual editing.
package org.intellij.plugins.tickscript.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;
import com.intellij.psi.tree.IElementType;

public interface KapacitorBinaryExpression extends KapacitorExpression {

  @NotNull
  KapacitorExpression getLOperand();

  @Nullable
  KapacitorExpression getROperand();

  @NotNull
  IElementType getOperationSign();

}
