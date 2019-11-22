
--------------------EditPostActivity.java
public void initializeEditorFragment() {
if (mEditorFragment instanceof AztecEditorFragment) {
AztecEditorFragment aztecEditorFragment = (AztecEditorFragment)mEditorFragment;
aztecEditorFragment.setEditorBetaClickListener(EditPostActivity.this);
aztecEditorFragment.setEditorImageSettingsListener(EditPostActivity.this);
Drawable loadingVideoPlaceholder = getResources().getDrawable(org.wordpress.android.editor.R.drawable.ic_gridicons_video_camera);
loadingVideoPlaceholder.setBounds(0, 0,AztecEditorFragment.DEFAULT_MEDIA_PLACEHOLDER_DIMENSION_DP,AztecEditorFragment.DEFAULT_MEDIA_PLACEHOLDER_DIMENSION_DP);//The functional module of image displaying     buggy code
aztecEditorFragment.setAztecVideoLoader(new AztecVideoLoader(getBaseContext(), loadingVideoPlaceholder));
aztecEditorFragment.setLoadingVideoPlaceholder(loadingVideoPlaceholder);









