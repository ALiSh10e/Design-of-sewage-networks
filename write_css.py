css_content = """/*! tailwindcss v4.3.0 | MIT License | https://tailwindcss.com */
@layer properties{
  @supports (((-webkit-hyphens:none)) and (not (margin-trim:inline))) or ((-moz-orient:inline) and (not (color:rgb(from red r g b)))){
    *,:before,:after,::backdrop{
      --tw-rotate-x:initial;--tw-rotate-y:initial;--tw-rotate-z:initial;--tw-skew-x:initial;--tw-skew-y:initial;
      --tw-space-y-reverse:0;--tw-divide-y-reverse:0;--tw-border-style:solid;--tw-gradient-position:initial;
      --tw-gradient-from:#0000;--tw-gradient-via:#0000;--tw-gradient-to:#0000;--tw-gradient-stops:initial;
      --tw-gradient-via-stops:initial;--tw-gradient-from-position:0%;--tw-gradient-via-position:50%;
      --tw-gradient-to-position:100%;--tw-leading:initial;--tw-font-weight:initial;--tw-tracking:initial;
      --tw-shadow:0 0 #0000;--tw-shadow-color:initial;--tw-shadow-alpha:100%;--tw-inset-shadow:0 0 #0000;
      --tw-inset-shadow-color:initial;--tw-inset-shadow-alpha:100%;--tw-ring-color:initial;--tw-ring-shadow:0 0 #0000;
      --tw-inset-ring-color:initial;--tw-inset-ring-shadow:0 0 #0000;--tw-ring-inset:initial;--tw-ring-offset-width:0px;
      --tw-ring-offset-color:#fff;--tw-ring-offset-shadow:0 0 #0000;--tw-blur:initial;--tw-brightness:initial;
      --tw-contrast:initial;--tw-grayscale:initial;--tw-hue-rotate:initial;--tw-invert:initial;--tw-opacity:initial;
      --tw-saturate:initial;--tw-sepia:initial;--tw-drop-shadow:initial;--tw-drop-shadow-color:initial;
      --tw-drop-shadow-alpha:100%;--tw-drop-shadow-size:initial;--tw-backdrop-blur:initial;
      --tw-backdrop-brightness:initial;--tw-backdrop-contrast:initial;--tw-backdrop-grayscale:initial;
      --tw-backdrop-hue-rotate:initial;--tw-backdrop-invert:initial;--tw-backdrop-opacity:initial;
      --tw-backdrop-saturate:initial;--tw-backdrop-sepia:initial;--tw-duration:initial
    }
  }
}
@layer theme{
  :root,:host{
    --font-sans:system-ui, -apple-system, BlinkMacSystemFont, "Segoe UI", Roboto, "Helvetica Neue", Arial, sans-serif;
    --font-mono:ui-monospace, SFMono-Regular, Menlo, Monaco, Consolas, "Liberation Mono", "Courier New", monospace;
    --color-red-300:#fca5a5;--color-red-400:#f87171;--color-red-500:#ef4444;--color-red-800:#991b1b;--color-red-900:#7f1d1d;--color-red-950:#450a0a;
    --color-amber-300:#fcd34d;--color-amber-400:#fbbf24;--color-amber-500:#f59e0b;--color-amber-900:#78350f;
    --color-emerald-300:#6ee7b7;--color-emerald-400:#34d399;--color-emerald-500:#10b981;--color-emerald-600:#059669;--color-emerald-900:#064e3b;--color-emerald-950:#022c22;
    --color-cyan-200:#a5f3fc;--color-cyan-300:#67e8f9;--color-cyan-400:#22d3ee;--color-cyan-500:#06b6d4;--color-cyan-600:#0891b2;
    --color-blue-300:#93c5fd;--color-blue-400:#60a5fa;--color-blue-500:#3b82f6;--color-blue-600:#2563eb;--color-blue-700:#1d4ed8;--color-blue-900:#1e3a8a;
    --color-indigo-400:#818cf8;--color-indigo-500:#6366f1;--color-indigo-600:#4f46e5;
    --color-rose-100:#ffe4e6;--color-rose-300:#fda4af;--color-rose-400:#fb7185;--color-rose-500:#f43f5e;--color-rose-900:#881337;--color-rose-950:#4c0519;
    --color-slate-100:#f1f5f9;--color-slate-200:#e2e8f0;--color-slate-300:#cbd5e1;--color-slate-400:#94a3b8;--color-slate-500:#64748b;--color-slate-600:#475569;--color-slate-700:#334155;--color-slate-800:#1e293b;--color-slate-900:#0f172a;--color-slate-950:#020617;
    --color-white:#fff;--spacing:0.25rem;--container-7xl:80rem;--text-xs:0.75rem;--text-sm:0.875rem;--text-lg:1.125rem;--text-xl:1.25rem;--text-2xl:1.5rem;
    --font-weight-medium:500;--font-weight-semibold:600;--font-weight-bold:700;--font-weight-extrabold:800;--font-weight-black:900;
    --tracking-tight:-0.025em;--tracking-wide:0.025em;--tracking-wider:0.05em;--leading-tight:1.25;--leading-normal:1.5;--leading-relaxed:1.625;
    --radius-sm:0.25rem;--radius-lg:0.5rem;--radius-xl:0.75rem;--radius-2xl:1rem;--drop-shadow-md:0 3px 3px rgba(0,0,0,0.12);
    --animate-pulse:pulse 2s cubic-bezier(0.4, 0, 0.6, 1) infinite;--animate-bounce:bounce 1s infinite;--blur-sm:8px;--blur-md:12px;
    --default-transition-duration:0.15s;--default-transition-timing-function:cubic-bezier(0.4, 0, 0.2, 1);
  }
}
@layer base{
  *,:after,:before,::backdrop{box-sizing:border-box;border:0 solid;margin:0;padding:0}
  html,:host{-webkit-text-size-adjust:100%;tab-size:4;line-height:1.5;font-family:var(--font-sans);-webkit-tap-highlight-color:transparent}
  body{margin:0;line-height:inherit;background-color:#0F172A;color:#f1f5f9;font-family:var(--font-sans)}
  table{text-indent:0;border-color:inherit;border-collapse:collapse}
  button,input,select,optgroup,textarea{font:inherit;letter-spacing:inherit;color:inherit;opacity:1;background-color:transparent;border-radius:0}
  button,input:where([type=button],[type=reset],[type=submit]){appearance:button}
}
.pointer-events-none{pointer-events:none}
.absolute{position:absolute}
.relative{position:relative}
.static{position:static}
.sticky{position:sticky}
.inset-0{inset:0}
.top-0{top:0}
.z-10{z-index:10}
.z-50{z-index:50}
.mx-1{margin-left:0.25rem;margin-right:0.25rem}
.mx-auto{margin-left:auto;margin-right:auto}
.my-2{margin-top:0.5rem;margin-bottom:0.5rem}
.mt-0\\.5{margin-top:0.125rem}
.mt-1{margin-top:0.25rem}
.mt-1\\.5{margin-top:0.375rem}
.mt-2{margin-top:0.5rem}
.mt-2\\.5{margin-top:0.625rem}
.mt-3{margin-top:0.75rem}
.mt-4{margin-top:1rem}
.mt-12{margin-top:3rem}
.mb-0\\.5{margin-bottom:0.125rem}
.mb-1{margin-bottom:0.25rem}
.mb-1\\.5{margin-bottom:0.375rem}
.mb-2{margin-bottom:0.5rem}
.mb-3{margin-bottom:0.75rem}
.mb-4{margin-bottom:1rem}
.ml-1{margin-left:0.25rem}
.block{display:block}
.flex{display:flex}
.grid{display:grid}
.hidden{display:none}
.inline-block{display:inline-block}
.inline-flex{display:inline-flex}
.table{display:table}
.h-1{height:0.25rem}
.h-1\\.5{height:0.375rem}
.h-2{height:0.5rem}
.h-2\\.5{height:0.625rem}
.h-3{height:0.75rem}
.h-3\\.5{height:0.875rem}
.h-4{height:1rem}
.h-5{height:1.25rem}
.h-6{height:1.5rem}
.h-8{height:2rem}
.h-10{height:2.5rem}
.h-14{height:3.5rem}
.h-36{height:9rem}
.h-\\[220px\\]{height:220px}
.h-\\[250px\\]{height:250px}
.h-\\[400px\\]{height:400px}
.h-full{height:100%}
.h-px{height:1px}
.max-h-\\[80px\\]{max-height:80px}
.max-h-\\[300px\\]{max-height:300px}
.max-h-\\[340px\\]{max-height:340px}
.min-h-screen{min-height:100vh}
.w-1\\.5{width:0.375rem}
.w-2{width:0.5rem}
.w-2\\.5{width:0.625rem}
.w-3{width:0.75rem}
.w-3\\.5{width:0.875rem}
.w-4{width:1rem}
.w-5{width:1.25rem}
.w-8{width:2rem}
.w-10{width:2.5rem}
.w-14{width:3.5rem}
.w-20{width:5rem}
.w-24{width:6rem}
.w-36{width:9rem}
.w-44{width:11rem}
.w-full{width:100%}
.max-w-7xl{max-width:80rem}
.max-w-\\[200px\\]{max-width:200px}
.min-w-\\[124px\\]{min-width:124px}
.min-w-\\[800px\\]{min-width:800px}
.flex-1{flex:1 1 0%}
.flex-shrink-0,.shrink-0{flex-shrink:0}
.border-collapse{border-collapse:collapse}
.animate-bounce{animation:bounce 1s infinite}
.animate-pulse{animation:pulse 2s cubic-bezier(0.4, 0, 0.6, 1) infinite}
.cursor-pointer{cursor:pointer}
.appearance-none{-webkit-appearance:none;appearance:none}
.grid-cols-1{grid-template-columns:repeat(1,minmax(0,1fr))}
.grid-cols-2{grid-template-columns:repeat(2,minmax(0,1fr))}
.flex-col{flex-direction:column}
.flex-wrap{flex-wrap:wrap}
.items-center{align-items:center}
.items-end{align-items:flex-end}
.items-start{align-items:flex-start}
.justify-between{justify-content:space-between}
.justify-center{justify-content:center}
.justify-end{justify-content:flex-end}
.justify-start{justify-content:flex-start}
.gap-0\\.5{gap:0.125rem}
.gap-1{gap:0.25rem}
.gap-1\\.5{gap:0.375rem}
.gap-2{gap:0.5rem}
.gap-3{gap:0.75rem}
.gap-4{gap:1rem}
.gap-5{gap:1.25rem}
.gap-6{gap:1.5rem}
.space-y-0\\.5 > :not([hidden]) ~ :not([hidden]){margin-top:0.125rem}
.space-y-1 > :not([hidden]) ~ :not([hidden]){margin-top:0.25rem}
.space-y-1\\.5 > :not([hidden]) ~ :not([hidden]){margin-top:0.375rem}
.space-y-2 > :not([hidden]) ~ :not([hidden]){margin-top:0.5rem}
.space-y-3 > :not([hidden]) ~ :not([hidden]){margin-top:0.75rem}
.space-y-3\\.5 > :not([hidden]) ~ :not([hidden]){margin-top:0.875rem}
.space-y-4 > :not([hidden]) ~ :not([hidden]){margin-top:1rem}
.space-y-5 > :not([hidden]) ~ :not([hidden]){margin-top:1.25rem}
.space-y-6 > :not([hidden]) ~ :not([hidden]){margin-top:1.5rem}
.divide-y > :not([hidden]) ~ :not([hidden]){border-top-width:1px}
.divide-slate-800\\/40 > :not([hidden]) ~ :not([hidden]){border-color:rgba(30,41,59,0.4)}
.truncate{overflow:hidden;text-overflow:ellipsis;white-space:nowrap}
.overflow-hidden{overflow:hidden}
.overflow-x-auto{overflow-x:auto}
.overflow-y-auto{overflow-y:auto}
.rounded{border-radius:0.25rem}
.rounded-2xl{border-radius:1rem}
.rounded-full{border-radius:9999px}
.rounded-lg{border-radius:0.5rem}
.rounded-sm{border-radius:0.125rem}
.rounded-xl{border-radius:0.75rem}
.border{border-width:1px}
.border-4{border-width:4px}
.border-t{border-top-width:1px}
.border-r{border-right-width:1px}
.border-b{border-bottom-width:1px}
.border-l{border-left-width:1px}
.border-dashed{border-style:dashed}
.border-none{border-style:none}
.border-amber-500\\/20{border-color:rgba(245,158,11,0.2)}
.border-amber-500\\/45{border-color:rgba(245,158,11,0.45)}
.border-amber-900\\/60{border-color:rgba(120,53,15,0.6)}
.border-blue-500{border-color:#3b82f6}
.border-blue-500\\/20{border-color:rgba(59,130,246,0.2)}
.border-blue-500\\/30{border-color:rgba(59,130,246,0.3)}
.border-cyan-300\\/40{border-color:rgba(103,232,249,0.4)}
.border-emerald-500\\/10{border-color:rgba(16,185,129,0.1)}
.border-emerald-500\\/20{border-color:rgba(16,185,129,0.2)}
.border-emerald-500\\/30{border-color:rgba(16,185,129,0.3)}
.border-emerald-900\\/40{border-color:rgba(6,78,59,0.4)}
.border-indigo-500\\/30{border-color:rgba(99,102,241,0.3)}
.border-red-800\\/60{border-color:rgba(153,27,27,0.6)}
.border-red-900\\/60{border-color:rgba(127,29,29,0.6)}
.border-rose-500\\/20{border-color:rgba(244,63,94,0.2)}
.border-rose-900\\/60{border-color:rgba(136,19,55,0.6)}
.border-slate-500{border-color:#64748b}
.border-slate-700{border-color:#334155}
.border-slate-700\\/60{border-color:rgba(51,65,85,0.6)}
.border-slate-700\\/80{border-color:rgba(51,65,85,0.8)}
.border-slate-800{border-color:#1e293b}
.border-slate-800\\/40{border-color:rgba(30,41,59,0.4)}
.border-slate-800\\/45{border-color:rgba(30,41,59,0.45)}
.border-slate-800\\/50{border-color:rgba(30,41,59,0.5)}
.border-slate-800\\/60{border-color:rgba(30,41,59,0.6)}
.border-slate-800\\/80{border-color:rgba(30,41,59,0.8)}
.border-slate-800\\/90{border-color:rgba(30,41,59,0.9)}
.bg-\\[\\#0B0F19\\]\\/40{background-color:rgba(11,15,25,0.4)}
.bg-\\[\\#0B0F19\\]\\/60{background-color:rgba(11,15,25,0.6)}
.bg-\\[\\#0B0F19\\]\\/90{background-color:rgba(11,15,25,0.9)}
.bg-\\[\\#0F172A\\]{background-color:#0f172a}
.bg-\\[\\#0F172A\\]\\/40{background-color:rgba(15,23,42,0.4)}
.bg-\\[\\#0b0f1a\\]{background-color:#0b0f1a}
.bg-\\[\\#0c1221\\]{background-color:#0c1221}
.bg-\\[\\#1E1B4B\\]\\/60{background-color:rgba(30,27,75,0.6)}
.bg-\\[\\#1E293B\\]{background-color:#1e293b}
.bg-\\[\\#064E3B\\]\\/20{background-color:rgba(6,78,59,0.2)}
.bg-\\[\\#141C2E\\]{background-color:#141c2e}
.bg-\\[\\#121929\\]{background-color:#121929}
.bg-amber-500{background-color:#f59e0b}
.bg-amber-500\\/5{background-color:rgba(245,158,11,0.05)}
.bg-amber-500\\/10{background-color:rgba(245,158,11,0.1)}
.bg-amber-500\\/25{background-color:rgba(245,158,11,0.25)}
.bg-blue-500{background-color:#3b82f6}
.bg-blue-500\\/10{background-color:rgba(59,130,246,0.1)}
.bg-blue-600{background-color:#2563eb}
.bg-blue-600\\/10{background-color:rgba(37,99,235,0.1)}
.bg-blue-900\\/60{background-color:rgba(30,58,138,0.6)}
.bg-cyan-600{background-color:#0891b2}
.bg-emerald-500{background-color:#10b981}
.bg-emerald-500\\/5{background-color:rgba(16,185,129,0.05)}
.bg-emerald-500\\/10{background-color:rgba(16,185,129,0.1)}
.bg-emerald-500\\/15{background-color:rgba(16,185,129,0.15)}
.bg-emerald-600{background-color:#059669}
.bg-emerald-950\\/10{background-color:rgba(2,44,34,0.1)}
.bg-indigo-500\\/10{background-color:rgba(99,102,241,0.1)}
.bg-indigo-600{background-color:#4f46e5}
.bg-red-500\\/5{background-color:rgba(239,68,68,0.05)}
.bg-red-950\\/40{background-color:rgba(69,10,10,0.4)}
.bg-rose-500{background-color:#f43f5e}
.bg-rose-500\\/10{background-color:rgba(244,63,94,0.1)}
.bg-rose-950\\/20{background-color:rgba(76,5,25,0.2)}
.bg-slate-700{background-color:#334155}
.bg-slate-800{background-color:#1e293b}
.bg-slate-800\\/40{background-color:rgba(30,41,59,0.4)}
.bg-slate-900{background-color:#0f172a}
.bg-slate-900\\/10{background-color:rgba(15,23,42,0.1)}
.bg-slate-900\\/20{background-color:rgba(15,23,42,0.2)}
.bg-slate-900\\/30{background-color:rgba(15,23,42,0.3)}
.bg-slate-900\\/40{background-color:rgba(15,23,42,0.4)}
.bg-slate-900\\/60{background-color:rgba(15,23,42,0.6)}
.bg-slate-900\\/95{background-color:rgba(15,23,42,0.95)}
.bg-slate-950{background-color:#020617}
.bg-slate-950\\/30{background-color:rgba(2,6,23,0.3)}
.bg-slate-950\\/40{background-color:rgba(2,6,23,0.4)}
.bg-slate-950\\/50{background-color:rgba(2,6,23,0.5)}
.bg-slate-950\\/80{background-color:rgba(2,6,23,0.8)}
.bg-slate-950\\/90{background-color:rgba(2,6,23,0.9)}
.bg-transparent{background-color:transparent}
.bg-gradient-to-t{background-image:linear-gradient(to top, var(--tw-gradient-stops, rgba(0,0,0,0)))}
.bg-gradient-to-tr{background-image:linear-gradient(to top right, var(--tw-gradient-stops, rgba(0,0,0,0)))}
.from-blue-600\\/60{--tw-gradient-from:rgba(37,99,235,0.6);--tw-gradient-stops:var(--tw-gradient-from), var(--tw-gradient-to, rgba(37,99,235,0))}
.from-blue-700{--tw-gradient-from:#1d4ed8;--tw-gradient-stops:var(--tw-gradient-from), var(--tw-gradient-to, rgba(29,78,216,0))}
.to-blue-400\\/80{--tw-gradient-to:rgba(96,165,250,0.8)}
.to-indigo-600{--tw-gradient-to:#4f46e5}
.fill-blue-300{fill:#93c5fd}
.fill-rose-100{fill:#ffe4e6}
.fill-slate-300{fill:#cbd5e1}
.fill-slate-500{fill:#64748b}
.p-0\\.5{padding:0.125rem}
.p-1{padding:0.25rem}
.p-1\\.5{padding:0.375rem}
.p-2{padding:0.5rem}
.p-2\\.5{padding:0.625rem}
.p-3{padding:0.75rem}
.p-3\\.5{padding:0.875rem}
.p-4{padding:1rem}
.p-5{padding:1.25rem}
.p-6{padding:1.5rem}
.p-8{padding:2rem}
.px-1{padding-left:0.25rem;padding-right:0.25rem}
.px-1\\.5{padding-left:0.375rem;padding-right:0.375rem}
.px-2{padding-left:0.5rem;padding-right:0.5rem}
.px-2\\.5{padding-left:0.625rem;padding-right:0.625rem}
.px-3{padding-left:0.75rem;padding-right:0.75rem}
.px-4{padding-left:1rem;padding-right:1rem}
.px-5{padding-left:1.25rem;padding-right:1.25rem}
.px-6{padding-left:1.5rem;padding-right:1.5rem}
.py-0\\.5{padding-top:0.125rem;padding-bottom:0.125rem}
.py-1{padding-top:0.25rem;padding-bottom:0.25rem}
.py-1\\.5{padding-top:0.375rem;padding-bottom:0.375rem}
.py-2{padding-top:0.5rem;padding-bottom:0.5rem}
.py-2\\.5{padding-top:0.625rem;padding-bottom:0.625rem}
.py-3{padding-top:0.75rem;padding-bottom:0.75rem}
.py-6{padding-top:1.5rem;padding-bottom:1.5rem}
.py-8{padding-top:2rem;padding-bottom:2rem}
.pt-1{padding-top:0.25rem}
.pt-1\\.5{padding-top:0.375rem}
.pt-2{padding-top:0.5rem}
.pt-4{padding-top:1rem}
.pr-1{padding-right:0.25rem}
.pr-2{padding-right:0.5rem}
.pb-1{padding-bottom:0.25rem}
.pb-1\\.5{padding-bottom:0.375rem}
.pb-2{padding-bottom:0.5rem}
.pb-3{padding-bottom:0.75rem}
.text-center{text-align:center}
.text-left{text-align:left}
.text-right{text-align:right}
.font-mono{font-family:var(--font-mono)}
.font-sans{font-family:var(--font-sans)}
.text-2xl{font-size:1.5rem;line-height:2rem}
.text-lg{font-size:1.125rem;line-height:1.75rem}
.text-sm{font-size:0.875rem;line-height:1.25rem}
.text-xs{font-size:0.75rem;line-height:1rem}
.text-\\[8px\\]{font-size:8px}
.text-\\[9px\\]{font-size:9px}
.text-\\[10px\\]{font-size:10px}
.text-\\[11px\\]{font-size:11px}
.leading-5{line-height:1.25rem}
.leading-6{line-height:1.5rem}
.leading-normal{line-height:1.5}
.leading-relaxed{line-height:1.625}
.leading-tight{line-height:1.25}
.font-black{font-weight:900}
.font-bold{font-weight:700}
.font-extrabold{font-weight:800}
.font-medium{font-weight:500}
.font-semibold{font-weight:600}
.tracking-tight{letter-spacing:-0.025em}
.tracking-wide{letter-spacing:0.025em}
.tracking-wider{letter-spacing:0.05em}
.whitespace-nowrap{white-space:nowrap}
.whitespace-pre-wrap{white-space:pre-wrap}
.text-amber-300{color:#fcd34d}
.text-amber-400{color:#fbbf24}
.text-amber-500{color:#f59e0b}
.text-blue-300{color:#93c5fd}
.text-blue-400{color:#60a5fa}
.text-blue-500{color:#3b82f6}
.text-cyan-200{color:#a5f3fc}
.text-cyan-400{color:#22d3ee}
.text-emerald-300{color:#6ee7b7}
.text-emerald-400{color:#34d399}
.text-emerald-400\\/80{color:rgba(52,211,153,0.8)}
.text-emerald-500{color:#10b981}
.text-indigo-400{color:#818cf8}
.text-red-300{color:#fca5a5}
.text-red-400{color:#f87171}
.text-rose-300{color:#fda4af}
.text-rose-400{color:#fb7185}
.text-slate-100{color:#f1f5f9}
.text-slate-200{color:#e2e8f0}
.text-slate-300{color:#cbd5e1}
.text-slate-400{color:#94a3b8}
.text-slate-500{color:#64748b}
.text-slate-600{color:#475569}
.text-white{color:#fff}
.lowercase{text-transform:lowercase}
.uppercase{text-transform:uppercase}
.underline{text-decoration-line:underline}
.accent-emerald-500{accent-color:#10b981}
.opacity-0{opacity:0}
.opacity-30{opacity:0.3}
.shadow{box-shadow:0 1px 3px 0 rgba(0,0,0,0.1), 0 1px 2px -1px rgba(0,0,0,0.1)}
.shadow-inner{box-shadow:inset 0 2px 4px 0 rgba(0,0,0,0.06)}
.shadow-lg{box-shadow:0 10px 15px -3px rgba(0,0,0,0.1), 0 4px 6px -4px rgba(0,0,0,0.1)}
.shadow-md{box-shadow:0 4px 6px -1px rgba(0,0,0,0.1), 0 2px 4px -2px rgba(0,0,0,0.1)}
.shadow-xl{box-shadow:0 20px 25px -5px rgba(0,0,0,0.1), 0 8px 10px -6px rgba(0,0,0,0.1)}
.shadow-blue-500\\/10{box-shadow:0 10px 15px -3px rgba(59,130,246,0.1)}
.shadow-cyan-500\\/10{box-shadow:0 10px 15px -3px rgba(6,182,212,0.1)}
.shadow-emerald-500\\/10{box-shadow:0 10px 15px -3px rgba(16,185,129,0.1)}
.shadow-indigo-600\\/15{box-shadow:0 10px 15px -3px rgba(79,70,229,0.15)}
.backdrop-blur-\\[1px\\]{backdrop-filter:blur(1px)}
.backdrop-blur-md{backdrop-filter:blur(12px)}
.backdrop-blur-sm{backdrop-filter:blur(8px)}
.transition-all{transition-property:all;transition-timing-function:cubic-bezier(0.4, 0, 0.2, 1);transition-duration:150ms}
.transition-colors{transition-property:color, background-color, border-color, text-decoration-color, fill, stroke;transition-timing-function:cubic-bezier(0.4, 0, 0.2, 1);transition-duration:150ms}
.duration-300{transition-duration:300ms}
.outline-none{outline:2px solid transparent;outline-offset:2px}
.select-none{user-select:none}
.select-text{user-select:text}
.selection\\:bg-blue-600 ::selection{background-color:#2563eb}
.selection\\:bg-blue-600::selection{background-color:#2563eb}
.selection\\:text-white ::selection{color:#fff}
.selection\\:text-white::selection{color:#fff}
.last\\:border-l-0:last-child{border-left-width:0px}
.hover\\:border-blue-500:hover{border-color:#3b82f6}
.hover\\:bg-amber-500\\/40:hover{background-color:rgba(245,158,11,0.4)}
.hover\\:bg-blue-500:hover{background-color:#3b82f6}
.hover\\:bg-blue-600\\/20:hover{background-color:rgba(37,99,235,0.2)}
.hover\\:bg-cyan-500:hover{background-color:#06b6d4}
.hover\\:bg-emerald-500:hover{background-color:#10b981}
.hover\\:bg-indigo-500:hover{background-color:#6366f1}
.hover\\:bg-rose-500\\/10:hover{background-color:rgba(244,63,94,0.1)}
.hover\\:bg-slate-700:hover{background-color:#334155}
.hover\\:bg-slate-800\\/40:hover{background-color:rgba(30,41,59,0.4)}
.hover\\:bg-slate-800\\/80:hover{background-color:rgba(30,41,59,0.8)}
.hover\\:bg-slate-900\\/40:hover{background-color:rgba(15,23,42,0.4)}
.hover\\:bg-slate-900\\/50:hover{background-color:rgba(15,23,42,0.5)}
.hover\\:text-blue-300:hover{color:#93c5fd}
.hover\\:text-rose-300:hover{color:#fda4af}
.hover\\:text-slate-200:hover{color:#e2e8f0}
.hover\\:text-white:hover{color:#fff}
.focus\\:border-blue-500:focus{border-color:#3b82f6}
.focus\\:border-rose-500:focus{border-color:#f43f5e}
.focus\\:ring-1:focus{box-shadow:0 0 0 1px #3b82f6}
.disabled\\:opacity-40:disabled{opacity:0.4}
@media (min-width: 640px){
  .sm\\:flex{display:flex}
  .sm\\:w-auto{width:auto}
  .sm\\:grid-cols-3{grid-template-columns:repeat(3,minmax(0,1fr))}
  .sm\\:flex-row{flex-direction:row}
  .sm\\:items-center{align-items:center}
  .sm\\:p-6{padding:1.5rem}
  .sm\\:px-6{padding-left:1.5rem;padding-right:1.5rem}
}
@media (min-width: 768px){
  .md\\:w-auto{width:auto}
  .md\\:grid-cols-4{grid-template-columns:repeat(4,minmax(0,1fr))}
  .md\\:flex-row{flex-direction:row}
  .md\\:flex-nowrap{flex-wrap:nowrap}
  .md\\:items-center{align-items:center}
  .md\\:border-r-4{border-right-width:4px}
  .md\\:border-l-0{border-left-width:0px}
  .md\\:pl-4{padding-left:1rem}
  .md\\:text-xl{font-size:1.25rem;line-height:1.75rem}
}
@media (min-width: 1024px){
  .lg\\:col-span-1{grid-column:span 1 / span 1}
  .lg\\:col-span-3{grid-column:span 3 / span 3}
  .lg\\:col-span-4{grid-column:span 4 / span 4}
  .lg\\:col-span-8{grid-column:span 8 / span 8}
  .lg\\:grid-cols-2{grid-template-columns:repeat(2,minmax(0,1fr))}
  .lg\\:grid-cols-4{grid-template-columns:repeat(4,minmax(0,1fr))}
  .lg\\:grid-cols-12{grid-template-columns:repeat(12,minmax(0,1fr))}
  .lg\\:px-8{padding-left:2rem;padding-right:2rem}
}
@keyframes pulse{50%{opacity:.5}}
@keyframes bounce{0%,to{animation-timing-function:cubic-bezier(.8,0,1,1);transform:translateY(-25%)}50%{animation-timing-function:cubic-bezier(0,0,.2,1);transform:none}}
"""

with open('/app/src/main/assets/styles.css', 'w', encoding='utf-8') as f:
    f.write(css_content)
print("styles.css created successfully")
