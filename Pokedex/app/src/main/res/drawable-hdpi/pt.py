for path in pathlib.Path(".").iterdir():
	if path.is_file():
		old_name = path.stem
		old_extension = path.suffix
		directory = path.parent
		new_name = "a" + old_name + old_extension
	path.rename(pathlib.Path(directory, new_name))
