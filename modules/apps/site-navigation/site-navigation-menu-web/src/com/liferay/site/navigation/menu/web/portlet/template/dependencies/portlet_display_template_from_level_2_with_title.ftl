<#if entries?? && entries?has_content && (entries?size >= 2) >

	<#assign includeAllChildEntries = false />
	<#assign layoutLevel = 2 />
	<#assign rootNavigationItem = entries[1] />

	<div class="nav-menu nav-menu-style-${bulletStyle}">
		<h2>
			<a href="${rootNavigationItem.getRegularURL()}" ${rootNavigationItem.getTarget()}>${rootNavigationItem.getName()}</a>
		</h2>

		<@displayChildNavigation childNavigationItems=rootNavigationItem.getChildren() childLayoutLevel=layoutLevel includeAllChildEntries=includeAllChildEntries />
	</div>
</#if>

<#macro displayChildNavigation
	childNavigationItems
	childLayoutLevel
	includeAllChildEntries
>
	<#if childNavigationItems?has_content>
		<ul class="layouts level-${childLayoutLevel}">
			<#list childNavigationItems as childNavigationItem>
				<li class="open">
					<a href="${childNavigationItem.getRegularURL()!""} ">${htmlUtil.escape(childNavigationItem.getName())}</a>

					<#if includeAllChildEntries || childNavigationItem.isBelongsToNavigationEntries(entries) >
						<@displayChildNavigation childNavigationItems=childNavigationItem.getChildren() childLayoutLevel=(childLayoutLevel + 1) includeAllChildEntries=includeAllChildEntries/>
					</#if>
				</li>
			</#list>
		</ul>
	</#if>
</#macro>