module.exports = {
  root: true,
  env: {
    browser: true,
    es2021: true,
  },
  extends: [
    "airbnb",
    "eslint:recommended",
    "plugin:@typescript-eslint/eslint-recommended",
    "plugin:@typescript-eslint/recommended",
    "prettier",
    "plugin:react/recommended",
  ],
  parser: "@typescript-eslint/parser",
  parserOptions: {
    ecmaFeatures: {
      jsx: true,
    },
    ecmaVersion: 12,
    sourceType: "module",
  },
  plugins: ["react", "@typescript-eslint", "prettier"],
  rules: {
    "no-console": 1,
    "prettier/prettier": 1,
    "@typescript-eslint/no-unused-vars": "error",
    // to enforce using type for object type definitions, can be type or interface
    "@typescript-eslint/consistent-type-definitions": ["error", "type"],
  },
  settings: {
    "import/resolver": {
      node: {
        extensions: [".js", ".jsx", ".ts", ".tsx"],
      },
    },
  },
};
