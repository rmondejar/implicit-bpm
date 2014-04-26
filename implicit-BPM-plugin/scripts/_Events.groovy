import org.codehaus.gant.GantBinding

includeTargets << new File(implicitBpmPluginDir, "scripts/_ImplicitBpm.groovy")

eventCompileStart = { GantBinding compileBinding ->
	preCompileImplicitBpm()
}

eventCompileEnd = { GantBinding compileBinding ->
	weaveImplicitBpm()
}

