import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

// https://vitejs.dev/config/
export default defineConfig({
  plugins: [
    vue(),
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
        target: 'http://localhost:8888',
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
