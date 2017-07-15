// This is a generated file. Not intended for manual editing.
package org.intellij.plugins.kapacitor.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface KapacitorPrimaryUnaryExpr extends PsiElement {

  @Nullable
  KapacitorPrimaryFunc getPrimaryFunc();

  @Nullable
  KapacitorIdentifier getIdentifier();

  @Nullable
  KapacitorLiteral getLiteral();

  @Nullable
  KapacitorPrimaryExpr getPrimaryExpr();

  @Nullable
  KapacitorPrimaryUnaryExpr getPrimaryUnaryExpr();

}
