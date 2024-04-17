import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import { manualChunksPlugin } from 'vite-plugin-webpackchunkname';

import ckeditor5 from '@ckeditor/vite-plugin-ckeditor5';
import { createRequire } from 'node:module';
const require = createRequire(import.meta.url);


// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    vue(),
    manualChunksPlugin(), 
    ckeditor5({ theme: require.resolve('@ckeditor/ckeditor5-theme-lark') })
  ],
  // css: {
  //   links: [
  //     'https://getbootstrap.com/docs/5.3/examples/blog/', 
  //     'https://cdn.jsdelivr.net/npm/@docsearch/css@3',
  //     'https://fonts.googleapis.com/css?family=Playfair&#43;Display:700,900&amp;display=swap'
  //   ]
  // },
  server: {
    proxy: {
      '/api': {
        target: 'http://localhost:30001',
        changeOrigin: true,
        rewrite: (path) => path.replace(/^\/api/, '')
      }
    }
  },
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  }
})
